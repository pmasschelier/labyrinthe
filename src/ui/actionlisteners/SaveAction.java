package ui.actionlisteners;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Enregistrer"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

final public class SaveAction implements ActionListener {
	
	final MazeController mazectrl;
	
	public SaveAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.saveMaze();
	}
}
