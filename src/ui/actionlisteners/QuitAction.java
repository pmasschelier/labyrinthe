package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;
import ui.Window;

final public class QuitAction implements ActionListener{
	
	final MazeController mazectrl;
	final Window app;
	
	public QuitAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			System.exit(0);
	}
}
