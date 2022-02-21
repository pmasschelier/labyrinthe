package ui;

import javax.swing.* ;

import controller.MazeController;
import ui.actionlisteners.SolveAction;

import java.awt.* ;

final public class SidePanel extends JPanel {
	
	private final JButton solveButton;
	
	public SidePanel(MazeController mazectrl) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new BoxChoserPanel(mazectrl));
		
		add(solveButton = new JButton("Solution"));
		solveButton.addActionListener(new SolveAction(mazectrl));
	}
}
