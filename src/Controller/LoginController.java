package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.User;
import View.Login;
import View.RegisterView;

public class LoginController implements ActionListener {
	Login log;
	User user;

	public LoginController() {
		this.log = new Login();
		log.getLoginBtn().addActionListener(this);
		log.getSignUpBtn().addActionListener(this);
		
	}
	
	public void checkUser(JTextField userField, JPasswordField passField) {
		if (userField.getText().equals("dani")) {
			log.getUserLabel().setText("Oki");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==log.getLoginBtn()) {
			checkUser(log.getUserField(),log.getPassField());
		}else if (e.getSource()==log.getSignUpBtn()) {
			new RegisterController();
		}
		
	}
	
	
}
