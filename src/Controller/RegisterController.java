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
	
	public void createUser() {
		Conector conn = new Conector();
		String name = rv.getTfName().getText();
		String username = rv.getTfUsername().getText();
		String password = String.valueOf(rv.getPfPassword().getPassword());
		String rPassword = String.valueOf(rv.getPfRPassword().getPassword());
		if (rPassword.equals(password)) {
			if (username.length()<3 || password.length()<3 || name.length()<3) {
				JOptionPane.showMessageDialog(null,"Debes rellenar todos los campos con almenos 3 caracteres");
			}else {
				if (conn.registerUser(name, username, password)) {
					JOptionPane.showMessageDialog(null,"Usuario creado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
				}	
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rv.getBtnRegister()) {
			createUser();
		}else if(e.getSource()==rv.getBtnCancel()) {
			rv.dispose();
		}
	}

}
