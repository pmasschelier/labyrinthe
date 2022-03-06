package ui;

import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private static final long serialVersionUID = -6698530414517354015L;
	
	ToolButton(Icon icon, String tooltipText, ActionListener action) {
		super(icon);
		setToolTipText(tooltipText);
		addActionListener(action);
		//setPreferredSize(new Dimension(100, 100));
	}

}
