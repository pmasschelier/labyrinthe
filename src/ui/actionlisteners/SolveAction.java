package ui.actionlisteners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;

/**
 * <b>Classe implémantant l'ActionListener qui répond à l'action "résoudre le labyrinthe"</b>
 * 
 * @author masschelier@telecom-paris.fr
 */
final public class SolveAction implements ActionListener {
	

	final MazeController mazectrl;

	public SolveAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		mazectrl.solve();
	}
	
}