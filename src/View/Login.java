package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import Model.Utilities;

public class Login extends JFrame{
	public JTextField userField;
	public JPasswordField passField;
	public JLabel userLabel, passLabel;
	public JButton loginBtn, signUpBtn;
	
	public Login() {
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);dispose();
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
		
		userField = new JTextField(20);
		passField = new JPasswordField(20);
		
		userLabel = new JLabel(Utilities.usernameLabel);
		passLabel = new JLabel(Utilities.passwordLabel);
		
		loginBtn = new JButton(Utilities.btnLoginText);
		signUpBtn = new JButton(Utilities.btnSignUpText);
		
		Dimension dm = new Dimension(150,25);
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

}
