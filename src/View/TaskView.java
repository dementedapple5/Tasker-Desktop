package View;

import javax.swing.*;

import org.apache.http.client.ClientProtocolException;

import Adapter.TaskRenderer;
import Model.Conector;
import Model.Task;

import java.awt.*;
import java.io.IOException;

public class TaskView extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			for(String userName : conector.obtenerUsuarios()) {
				
				JMenuItem menuItem1 = new JMenuItem(userName);
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

//        Task task1 = new Task("Tarea 1", "pepin", "","Escribir 1", 1);
//        Task task2 = new Task("Tarea 2", "pepin", "","Escribir 2", 2);
//        Task task3 = new Task("Tarea 3", "pepin", "","Escribir 3", 3);


        DefaultListModel<Task> listTasks = new DefaultListModel<>();
//        listTasks.addElement(task1);
//        listTasks.addElement(task2);
//        listTasks.addElement(task3);
        JList<Task> taskList = new JList<>(listTasks);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskView());
    }
}
