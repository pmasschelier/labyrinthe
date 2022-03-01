package ui;

import javax.swing.JButton;
import javax.swing.JToolBar;

import main.MazeController;
import ui.actionlisteners.CloseAction;
import ui.actionlisteners.CreateMazeAction;
import ui.actionlisteners.CreateRandomMazeAction;
import ui.actionlisteners.EraseAction;
import ui.actionlisteners.OpenAction;
import ui.actionlisteners.SaveAction;
import ui.actionlisteners.SolveAction;

/**
 * <b>Classe représentant la barre d'outil de la fenêtre</b>
 * <p>La barre d'outils contient 7 boutons :
 * <ul>
 * <li>Nouveau</li>
 * <li>Ouvrir</li>
 * <li>Enregistrer</li>
 * <li>Fermer</li>
 * <li>Aléatoire</li>
 * <li>Effacer</li>
 * <li>Résoudre</li>
 * </ul>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class ToolBar extends JToolBar {

	private static final long serialVersionUID = -350011054358769608L;
	
	private final JButton newButton, openButton, saveButton, closeButton, randomButton, clearButton, solveButton;

	public ToolBar(MazeController mazectrl) {
		
		super();

		newButton = new JButton(Window.icons.get("new"));
		newButton.addActionListener(new CreateMazeAction(mazectrl));
		newButton.setToolTipText("Nouveau labyrinthe");
		add(newButton);
		
		openButton = new JButton(Window.icons.get("open"));
		openButton.addActionListener(new OpenAction(mazectrl));
		openButton.setToolTipText("Ouvrir un labyrinthe");
		add(openButton);
		
		saveButton = new JButton(Window.icons.get("save"));
		saveButton.addActionListener(new SaveAction(mazectrl));
		saveButton.setToolTipText("Enregistrer le labyrinthe");
		add(saveButton);
		
		closeButton = new JButton(Window.icons.get("close"));
		closeButton.addActionListener(new CloseAction(mazectrl));
		closeButton.setToolTipText("Fermer le labyrinthe");
		add(closeButton);
		
		randomButton = new JButton(Window.icons.get("random"));
		randomButton.addActionListener(new CreateRandomMazeAction(mazectrl));
		randomButton.setToolTipText("Remplir aléatoirement le labyrinthe");
		add(randomButton);
		
		clearButton = new JButton(Window.icons.get("clear"));
		clearButton.addActionListener(new EraseAction(mazectrl));
		clearButton.setToolTipText("Effacer le labyrinthe");
		add(clearButton);
		
		solveButton = new JButton(Window.icons.get("apply"));
		solveButton.addActionListener(new SolveAction(mazectrl));
		solveButton.setToolTipText("Résoudre le labyrinthe");
		add(solveButton);
	}
}
