package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Créer un nouveau labyrinthe"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
final public class CreateMazeAction implements ActionListener {
	
	final MazeController mazectrl;
	
	public CreateMazeAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.newVoidMaze();		
	}
}
