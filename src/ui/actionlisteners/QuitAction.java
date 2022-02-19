package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.Window;

public class QuitAction implements ActionListener{
	
	Window window;
	
	public QuitAction(Window window) {
		this.window = window;
	}
	
	public void actionPerformed(ActionEvent e){
		int reponse = JOptionPane.showConfirmDialog(window,
			"Voulez-vous quitter l'application",
			"Confirmation",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);

		if (reponse == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}
