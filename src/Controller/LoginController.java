package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.User;
import View.Login;

public class LoginController implements ActionListener {
	Login log;
	User user;

	public LoginController() {
		this.log = new Login();
		log.getLoginBtn().addActionListener(this);
		
	}
	
	public void checkUser(JTextField userField, JPasswordField passField) {
		if (userField.getText().equals("dani") && passField.getPassword().equals("123")) {
			log.getUserLabel().setText("Oki");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==log.getLoginBtn()) {
			checkUser(log.getUserField(),log.getPassField());
		}
		
	}
	
	
}
