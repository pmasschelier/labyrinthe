package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.MazeController;
import ui.Window;

public class QuitAction implements ActionListener{
	
	MazeController mazectrl;
	Window app;
	
	public QuitAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			System.exit(0);
	}
}
