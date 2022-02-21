package ui.actionlisteners;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;
import ui.Window;

final public class SaveAsAction implements ActionListener {
	

	final MazeController mazectrl;
	final Window app;
	
	public SaveAsAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.saveAsMaze();
	}
}
