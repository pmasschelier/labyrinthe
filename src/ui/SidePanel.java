package ui;

import javax.swing.* ;

import main.MazeController;
import ui.actionlisteners.SolveAction;

import java.awt.* ;

/**
 * <b>Classe représentant le panneau de boutons en bas de la fenêtre</b>
 * <p>Le panneau contient d'abord un BoxChoserPanel puis un bouton pour résoudre
 * le labyrinthe.</p>
 * 
 * @see BoxChoserPanel
 * @see MazeController
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class SidePanel extends JPanel {
	
	private static final long serialVersionUID = 1704620989426022055L;
	
	private final JButton solveButton;
	
	public SidePanel(MazeController mazectrl) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new BoxChoserPanel(mazectrl));
		
		add(solveButton = new JButton("Solution"));
		solveButton.addActionListener(new SolveAction(mazectrl));
	}
}
