package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import Model.Task;
import View.TaskView;

public class TaskController implements ActionListener {
	TaskView taskView;
	HashSet<Task> tasks;
	
	public TaskController() {
		
		this.taskView = new TaskView();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public void setUsername(String username) {
		taskView.setTitle("Tareas "+username);
	}

	
}
