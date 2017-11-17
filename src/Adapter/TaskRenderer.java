package Adapter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

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
	private JLabel lbTitle = new JLabel();
	private JLabel lbDescription = new JLabel();
	private JPanel panelText;
	private JPanel panelIcon;

	public TaskRenderer() {
		setLayout(new BorderLayout(5, 5));

		panelText = new JPanel(new GridLayout(0, 1));
		panelText.add(lbTitle);
		panelText.add(lbDescription);

		panelIcon = new JPanel();
		panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIcon.add(lbEdit);

		add(panelIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Task> list,
			Task task, int index, boolean isSelected, boolean cellHasFocus) {

		lbEdit.setIcon(new ImageIcon("images/edit.png"));
		lbTitle.setText(task.getTitulo());
		lbDescription.setText(task.getContenido());
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
			setBackground(list.getSelectionBackground());
			panelIcon.setBackground(list.getSelectionBackground());
		} else { // when don't select
			lbTitle.setBackground(list.getBackground());
			lbDescription.setBackground(list.getBackground());
			lbEdit.setBackground(list.getBackground());
			setBackground(list.getBackground());
			panelIcon.setBackground(list.getBackground());
		}
		return this;
	}
}
