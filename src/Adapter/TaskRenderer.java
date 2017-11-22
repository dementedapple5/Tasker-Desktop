package Adapter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Model.Task;

public class TaskRenderer extends JPanel implements ListCellRenderer<Task>, ActionListener {

	private JButton btnEdit, btnDone;
	private JLabel lbDescription, lbTitle;
	private JPanel panelText;
	private Task task;

	public TaskRenderer() {
		
		BorderLayout item = new BorderLayout(5,5);
		setLayout(item);
		
		lbTitle = new JLabel();
		setMarginLeft(5,lbTitle);
		
		lbDescription = new JLabel();
		setMarginLeft(5,lbDescription);

		panelText = new JPanel(new GridLayout(0, 1));
		setMarginTop(10,panelText);
		
		panelText.add(lbTitle);
		panelText.add(lbDescription);

		btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.decode("#FFFFFF"));
		
		btnDone = new JButton("Complete");
		btnDone.setBackground(Color.decode("#FFFFFF"));
		
		JPanel p = new JPanel(new BorderLayout());
		
		p.add(btnEdit,BorderLayout.WEST);
		p.add(btnDone,BorderLayout.CENTER);
	

		add(p, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Task> list,
		Task task, int index, boolean isSelected, boolean cellHasFocus) {
		
		this.task = task;

		lbTitle.setText(task.getTitle());
		lbDescription.setText(task.getDescription());

		// set Opaque to change background color of JLabel
		lbTitle.setOpaque(true);
		lbDescription.setOpaque(true);
		
		lbTitle.setBackground(Color.decode("#FFFFFF"));
		lbDescription.setBackground(Color.decode("#FFFFFF"));
		
		if(task.getPriority() == 1) {
			lbTitle.setForeground(Color.decode("#B71C1C"));
		}else if (task.getPriority() == 2) {
			lbTitle.setForeground(Color.decode("#1A237E"));
		}else {
			lbTitle.setForeground(Color.decode("#009688"));
		}
		
		return this;
	}
	
	
	public static void setMarginLeft(int margin, JLabel label) {
		Border border = label.getBorder();
		Border margin1 = new EmptyBorder(0,margin,0,0);
		label.setBorder(new CompoundBorder(border, margin1));
	}
	
	public static void setMarginTop(int margin, JPanel panel) {
		Border border = panel.getBorder();
		Border margin1 = new EmptyBorder(margin,0,0,0);
		panel.setBorder(new CompoundBorder(border, margin1));
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDone() {
		return btnDone;
	}

	public Task getTask() {
		return task;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource()==btnDone) {
			System.out.println("Hello Cotto");
		}*/
		
	}
	
	
	
	
	
}
