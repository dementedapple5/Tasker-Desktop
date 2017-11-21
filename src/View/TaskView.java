package View;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import org.apache.http.client.ClientProtocolException;

import Adapter.TaskRenderer;
import Controller.TaskController;
import Model.Conector;
import Model.Task;
import Model.User;

import java.awt.*;
import java.io.IOException;

public class TaskView extends JFrame {

	private static final long serialVersionUID = 1L;
	public String currentUser;

	public TaskView()  {
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
        JMenu menu = new JMenu("Change user");
            
        Conector conector = new Conector();
        
        try {
			for(User userName : conector.obtenerUsuarios()) {
				JMenuItem menuItem1 = new JMenuItem(userName.getUsername());
				menu.add(menuItem1);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        menuBar.add(menu);
        
        menuBar.add(new JMenu("Refresh"));

        panel.add(menuBar, BorderLayout.PAGE_START);
    	
    	
		return panel;
    	
    }

    private JPanel createPanelTodo() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("Add Task"));
        menuBar.add(new JMenu("Refresh"));

        panel.add(menuBar, BorderLayout.PAGE_START);

        Conector conn = new Conector();
        
        DefaultListModel<Task> listTasks = new DefaultListModel<>();
        
        
        try {
        	System.out.println(currentUser);
			for(Task task: conn.obtenerTareas(currentUser)){
				listTasks.addElement(task);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
        
        JList<Task> taskList = new JList<Task>(listTasks);
        taskList.setCellRenderer(new TaskRenderer());
        
        panel.add(new JScrollPane(taskList));

        return panel;
    }

    private JPanel createPanelDone() {
        JPanel panel = new JPanel(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("Refresh"));

        panel.add(menuBar, BorderLayout.PAGE_START);

        return panel;
    }
    
}
