package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Fermer le labyrinthe"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
final public class CloseAction implements ActionListener {
	
	final MazeController mazectrl;

	public CloseAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			mazectrl.closeMaze();
	}
}