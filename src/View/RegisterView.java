package View;

import java.awt.*;

import javax.swing.*;

import Model.Utilities;

public class RegisterView extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTextField tfName, tfUsername;
	private JPasswordField pfPassword, pfRPassword;
	private JLabel lbTitle, lbName, lbUsername, lbPassword, lbRPassword;
	private JButton btnRegister, btnCancel;
	
	public RegisterView() {
		setTitle("REGISTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		addContentToPane(this.getContentPane());
		pack();
		setVisible(true);
		
	}
	
	public void addContentToPane(Container c) {
		JPanel fields = new JPanel(new GridLayout(4,2,-80,5));
		JPanel title = new JPanel();
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		
		lbTitle = new JLabel("REGISTER");
		lbTitle.setFont(Utilities.TITLE_FONT);
		title.add(lbTitle);
		
		lbName = new JLabel("Name");
		tfName = new JTextField(Utilities.FIELD_ROWS);
		
		lbUsername = new JLabel("Username");
		tfUsername = new JTextField(Utilities.FIELD_ROWS);
		
		lbPassword = new JLabel("Password");
		pfPassword = new JPasswordField (Utilities.FIELD_ROWS);
		
		lbRPassword = new JLabel("R-Password");
		pfRPassword = new JPasswordField(Utilities.FIELD_ROWS);
		
		btnRegister = new JButton("REGISTER");
		btnCancel = new JButton("CANCEL");
		
		buttons.add(btnCancel);
		buttons.add(btnRegister);
		
		fields.add(lbName);
		fields.add(tfName);
		
		fields.add(lbUsername);
		fields.add(tfUsername);
		
		fields.add(lbPassword);
		fields.add(pfPassword);
		
		fields.add(lbRPassword);
		fields.add(pfRPassword);
		
		c.add(title, BorderLayout.NORTH);
		c.add(fields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
			
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public JPasswordField getPfPassword() {
		return pfPassword;
	}

	public JPasswordField getPfRPassword() {
		return pfRPassword;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	
	
	

}
