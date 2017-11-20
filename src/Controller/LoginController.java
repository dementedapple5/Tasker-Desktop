package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import Model.Conector;
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
		Conector conn = new Conector();
		
		if (conn.checkUser(userField.getText(), String.valueOf(passField.getPassword()))) {
			System.out.println("BIENN");
			new TaskController();
			log.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
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
