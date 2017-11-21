package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Conector;
import Model.User;
import View.RegisterView;

public class RegisterController implements ActionListener {
	RegisterView rv;
	User user;
	
	public RegisterController() {
		rv = new RegisterView();
		rv.getBtnRegister().addActionListener(this);
		rv.getBtnCancel().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rv.getBtnRegister()) {
			Conector conn = new Conector();
			String name = rv.getTfName().getText();
			String username = rv.getTfUsername().getText();
			String password = String.valueOf(rv.getPfPassword().getPassword());
			String rPassword = String.valueOf(rv.getPfRPassword().getPassword());
			if (rPassword.equals(password)) {
				if (conn.registerUser(name, username, password)) {
					System.out.println("Usuario registrado");
				}else {
					System.out.println("Usuario no registrado");
				}	
			}else {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
			}
		}else if(e.getSource()==rv.getBtnCancel()) {
			rv.dispose();
		}
	}

}
