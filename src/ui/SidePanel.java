package ui;

import javax.swing.* ;

import controller.MazeController;
import ui.actionlisteners.SolveAction;

import java.awt.* ;

public class SidePanel extends JPanel {
	
	JButton solveButton;
	
	public SidePanel(MazeController mazectrl) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new BoxChoserPanel(mazectrl));
		
		add(solveButton = new JButton("Solve"));
		solveButton.addActionListener(new SolveAction(mazectrl));
	}
}
