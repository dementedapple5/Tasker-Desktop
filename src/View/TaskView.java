package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class TaskView extends JFrame{
	JMenuBar menuBar;
	JMenu addTask, refresh;
	
	private int screenHeight,screenWidth;

	
	public TaskView()  {
		
		
		setTitle("TASKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		Toolkit myScreen = Toolkit.getDefaultToolkit();
		Dimension screenSize = myScreen.getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		setSize(screenWidth/2,screenHeight/2);
		System.out.println(screenWidth/2);
		setLocation(screenWidth/4,screenHeight/4);
		placeComponents(this.getContentPane());
		
	}

	private void placeComponents(Container contentPane) {
		
		JPanel jsp1 = new JPanel();
        JPanel jsp2 = new JPanel();
        JLabel j1 = new JLabel("Area 1");
        JLabel j2 = new JLabel("Area 2");
        
        menuBar = new JMenuBar();
        addTask = new JMenu("Add Task");
        refresh = new JMenu("Refresh");
        menuBar.add(addTask);
        menuBar.add(refresh);   
        
        jsp1.add(menuBar);
         
        jsp1.add(j1);
        jsp2.add(j2);
              
         
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                true, jsp1, jsp2);
        
       splitPane.setUI(new BasicSplitPaneUI());
            
        splitPane.setOneTouchExpandable(false);
        contentPane.add(splitPane);
        splitPane.setEnabled(false);
        setVisible(true);
        splitPane.setDividerLocation(300);
	}
	
	
	
	

}
