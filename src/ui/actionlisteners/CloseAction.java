package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.MazeController;
import ui.Window;

public class CloseAction implements ActionListener {
	
	MazeController mazectrl;
	Window app;
	
	public CloseAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			mazectrl.closeMaze();
	}
}