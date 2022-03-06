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

		newButton = new ToolButton(Window.icons.get("new"), "Nouveau labyrinthe", new CreateMazeAction(mazectrl));
		add(newButton);

		openButton = new ToolButton(Window.icons.get("open"), "Ouvrir le labyrinthe", new OpenAction(mazectrl));
		add(openButton);

		saveButton = new ToolButton(Window.icons.get("save"), "Enregistrer le labyrinthe", new SaveAction(mazectrl));
		add(saveButton);

		closeButton = new ToolButton(Window.icons.get("close"), "Fermer le labyrinthe", new CloseAction(mazectrl));
		add(closeButton);

		randomButton = new ToolButton(Window.icons.get("random"), "Remplir aléatoirement le labyrinthe", new CreateRandomMazeAction(mazectrl));
		add(randomButton);

		clearButton = new ToolButton(Window.icons.get("clear"), "Effacer le labyrinthe", new EraseAction(mazectrl));
		add(clearButton);

		solveButton = new ToolButton(Window.icons.get("apply"), "Résoudre le labyrinthe", new SolveAction(mazectrl));
		add(solveButton);
	}
}
