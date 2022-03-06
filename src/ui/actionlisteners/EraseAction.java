package ui.actionlisteners;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Effacer le labyrinthe"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

final public class EraseAction implements ActionListener {
	
	final MazeController mazectrl;

	public EraseAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		if(mazectrl.getMaze() != null)
			mazectrl.newVoidMaze(mazectrl.getMaze().getSizeX(), mazectrl.getMaze().getSizeY());
	}
	
}