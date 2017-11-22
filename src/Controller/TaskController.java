package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.apache.http.client.ClientProtocolException;

import Adapter.TaskRenderer;
import Model.Conector;
import Model.Task;
import Model.TaskPojo;
import View.Login;
import View.TaskView;

public class TaskController implements ActionListener {
	TaskView taskView;
	private String currentUser;
	TaskRenderer tr;
	
	public TaskController(String currentUser) {
		this.currentUser = currentUser;
		taskView = new TaskView(currentUser);
		System.out.println("1:"+currentUser);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void setUsername(String username) {
		currentUser = username;
	}

	public String getCurrentUser() {
		return currentUser;
	}
	
	

	
}
