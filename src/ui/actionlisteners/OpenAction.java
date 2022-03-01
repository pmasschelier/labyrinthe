package ui.actionlisteners;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Ouvrir"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

final public class OpenAction implements ActionListener {
	
	final MazeController mazectrl;
	
	public OpenAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){		
		String filename = mazectrl.getWindow().getFilename("Ouvrir");

		if(filename != null && mazectrl.checkSaved())
				mazectrl.openMaze(filename);
			
	}
}
