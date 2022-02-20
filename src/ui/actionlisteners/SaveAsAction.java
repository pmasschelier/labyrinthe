package ui.actionlisteners;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;
import ui.Window;

public class SaveAsAction implements ActionListener {
	

	MazeController mazectrl;
	Window app;
	
	public SaveAsAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.saveAsMaze();
	}
}
