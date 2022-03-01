package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Créer un labyrinthe aléatoire"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
final public class CreateRandomMazeAction implements ActionListener {
	
	final MazeController mazectrl;
	
	public CreateRandomMazeAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.newRandomMaze();
	}
}
