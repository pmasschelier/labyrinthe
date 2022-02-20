package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;

public class SolveAction implements ActionListener {
	

	MazeController mazectrl;

	public SolveAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.solve();
	}
	
}