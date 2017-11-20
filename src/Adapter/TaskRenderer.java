package Adapter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import Model.Task;

public class TaskRenderer extends JPanel implements ListCellRenderer<Task> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbEdit = new JLabel();
	private JLabel lbCheck = new JLabel();
	private JLabel lbTitle = new JLabel();
	private JLabel lbDescription = new JLabel();
	private JPanel panelText;
	private JPanel panelEdit;
	private JPanel panelCheck;

	public TaskRenderer() {
		setLayout(new BorderLayout(5, 5));

		panelText = new JPanel(new GridLayout(0, 1));
		panelText.add(lbTitle);
		panelText.add(lbDescription);

		panelEdit = new JPanel();
		panelEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelEdit.add(lbEdit);
		
		panelCheck = new JPanel();
		panelCheck.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCheck.add(lbCheck);
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(panelEdit,BorderLayout.WEST);
		p.add(panelCheck,BorderLayout.CENTER);
	

		add(p, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Task> list,
			Task task, int index, boolean isSelected, boolean cellHasFocus) {
		
		ImageIcon checkIcon = new ImageIcon("images/check_box.png"); // load the image to a imageIcon
		Image image = checkIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		checkIcon = new ImageIcon(newimg);  // transform it back
		
		ImageIcon editIcon = new ImageIcon("images/edit.png"); // load the image to a imageIcon
		Image image2 = editIcon.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		editIcon = new ImageIcon(newimg2);  // transform it back
		
		
		
		

		lbCheck.setIcon(checkIcon);
		lbEdit.setIcon(editIcon);
		lbTitle.setText(task.getTitle());
		lbDescription.setText(task.getDescription());
		lbDescription.setForeground(Color.blue);

		// set Opaque to change background color of JLabel
		lbTitle.setOpaque(true);
		lbDescription.setOpaque(true);
		lbEdit.setOpaque(true);

		// when select item
		if (isSelected) {
			lbTitle.setBackground(list.getSelectionBackground());
			lbDescription.setBackground(list.getSelectionBackground());
			lbEdit.setBackground(list.getSelectionBackground());
			if(task.getPriority() == 1) {
				setBackground(Color.RED);
			}else if (task.getPriority() == 2) {
				setBackground(Color.YELLOW);
			}else {
				setBackground(Color.GREEN);
			}
			panelEdit.setBackground(list.getSelectionBackground());
		} else { // when don't select
			if(task.getPriority() == 1) {
				setBackground(Color.RED);
			}else if (task.getPriority() == 2) {
				setBackground(Color.YELLOW);
			}else {
				setBackground(Color.GREEN);
			}
		}
		return this;
	}
}
