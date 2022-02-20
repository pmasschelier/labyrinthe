package ui;

import javax.swing.* ;

import controller.MazeController;

import java.awt.* ;

public class SidePanel extends JPanel {
	
	public SidePanel(MazeController mazectrl) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new BoxChoserPanel(mazectrl));
		add(new JButton("Solve"));
	}
}
