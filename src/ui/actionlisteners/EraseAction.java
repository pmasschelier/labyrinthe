package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;

public class EraseAction implements ActionListener {
	

	MazeController mazectrl;

	public EraseAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.newVoidMaze(mazectrl.getMaze().getSizeX(), mazectrl.getMaze().getSizeY());
	}
	
}