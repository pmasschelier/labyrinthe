package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;

final public class CreateRandomMazeAction implements ActionListener {
	
	final MazeController mazectrl;
	
	public CreateRandomMazeAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.newRandomMaze();
	}
}
