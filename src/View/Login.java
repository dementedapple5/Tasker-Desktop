package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import Model.Utilities;

public class Login extends JFrame{
	private JTextField userField;
	private JPasswordField passField;
	private JLabel userLabel, passLabel;
	private JButton loginBtn, signUpBtn;
	
	public Login() {
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(this.getContentPane());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void addComponentsToPane(Container c) {
		
		JPanel flowNorth = new JPanel();
		flowNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel flowCenter = new JPanel();
		flowCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel flowSouth = new JPanel();
		
		userField = new JTextField(Utilities.FIELD_ROWS);
		passField = new JPasswordField(Utilities.FIELD_ROWS);
		
		userLabel = new JLabel(Utilities.usernameLabel);
		passLabel = new JLabel(Utilities.passwordLabel);
		
		loginBtn = new JButton(Utilities.btnLoginText);
		signUpBtn = new JButton(Utilities.btnSignUpText);
		
		Dimension dm = new Dimension(100,25);
		signUpBtn.setPreferredSize(dm);
		loginBtn.setPreferredSize(dm);
		
		flowNorth.add(userLabel);
		flowNorth.add(userField);
		
		flowCenter.add(passLabel);
		flowCenter.add(passField);
		
		flowSouth.add(loginBtn);
		flowSouth.add(signUpBtn);
		
		c.add(flowNorth, BorderLayout.NORTH);
		c.add(flowCenter, BorderLayout.CENTER);
		c.add(flowSouth, BorderLayout.SOUTH);
		
	}

	public JTextField getUserField() {
		return userField;
	}

	public JPasswordField getPassField() {
		return passField;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public JButton getSignUpBtn() {
		return signUpBtn;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}
	
	
	
	
	
	
	

}
