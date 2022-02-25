package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;

final public class EraseAction implements ActionListener {
	

	final MazeController mazectrl;

	public EraseAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		if(mazectrl.getMaze() != null)
			mazectrl.newVoidMaze(mazectrl.getMaze().getSizeX(), mazectrl.getMaze().getSizeY());
	}
	
}