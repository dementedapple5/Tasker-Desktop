package View;

import javax.swing.*;

import org.apache.http.client.ClientProtocolException;

import Adapter.TaskRenderer;
import Model.Conector;
import Model.Task;
import Model.User;

import java.awt.*;
import java.io.IOException;

public class TaskView extends JFrame {

	private static final long serialVersionUID = 1L;
	private String currentUser;
	private JMenu addTask,changeUser,refresh;
	private Conector conn;

	public TaskView(String currentUser)  {
		this.currentUser = currentUser;
		conn = new Conector();
        createGUI();
    }

    private void createGUI()  {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension screenSize = myScreen.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setPreferredSize(new Dimension(screenWidth / 2, screenHeight / 2));
        setLocation(screenWidth / 4, screenHeight / 4);
        
        add(createMenu(), BorderLayout.PAGE_START);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createPanelTodo(), createPanelDone());

        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);
        splitPane.setEnabled(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        splitPane.setDividerLocation(0.5);
    }
    
    private JPanel createMenu()  {
    	
    	JPanel panel = new JPanel(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        
        addTask = new JMenu("Add Task");
        refresh = new JMenu("refresh");
        changeUser = new JMenu("Change User");
            
          
        try {
			for(User userName : conn.obtenerUsuarios()) {
				JMenuItem menuItem1 = new JMenuItem(userName.getUsername());
				changeUser.add(menuItem1);
			}
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        menuBar.add(changeUser);
        menuBar.add(addTask);
        menuBar.add(refresh);

        panel.add(menuBar, BorderLayout.PAGE_START);
    	
    	
		return panel;
    	
    }

    private JPanel createPanelTodo() {
        JPanel panel = new JPanel(new BorderLayout());
        
        panel.add(new JScrollPane(addTasks(false,conn)));
        
        return panel;
    }

    private JPanel createPanelDone() {
        JPanel panel = new JPanel(new BorderLayout());
        
        panel.add(new JScrollPane(addTasks(true,conn)));

        return panel;
    }
    
    
    private JList<Task> addTasks(boolean isDone, Conector conn) {
        DefaultListModel<Task> listTasks = new DefaultListModel<>();
        
        try {
			for(Task task: conn.obtenerTareas(currentUser)){
				if (task.isState()==isDone) {
					listTasks.addElement(task);
				}
			}
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        
        JList<Task> taskList = new JList<Task>(listTasks);
        
        taskList.setCellRenderer(new TaskRenderer());
        
        return taskList;
    }
    
    
    
}
