package ui.actionlisteners;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "Quitter"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

final public class QuitAction implements ActionListener{
	
	final MazeController mazectrl;
	
	public QuitAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}
	
	public void actionPerformed(ActionEvent e){
		if (mazectrl.checkSaved())
			System.exit(0);
	}
}
