package ui.actionlisteners;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;
import ui.Window;

public class SaveAction implements ActionListener {
	
	MazeController mazectrl;
	Window app;
	
	public SaveAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.saveMaze();
	}
}
