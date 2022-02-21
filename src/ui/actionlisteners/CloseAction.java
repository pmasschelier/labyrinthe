package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.MazeController;
import ui.Window;

final public class CloseAction implements ActionListener {
	
	final MazeController mazectrl;
	final Window app;
	
	public CloseAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			mazectrl.closeMaze();
	}
}