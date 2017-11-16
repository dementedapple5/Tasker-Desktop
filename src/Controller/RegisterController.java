package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.User;
import View.RegisterView;

public class RegisterController implements ActionListener {
	RegisterView rv;
	User user;
	
	public RegisterController() {
		rv = new RegisterView();
		rv.getBtnRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rv.getBtnRegister()) {
			rv.dispose();
		}else if(e.getSource()==rv.getBtnRegister()) {
			rv.dispose();
		}
	}

}
