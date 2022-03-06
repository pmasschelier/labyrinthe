package ui;

import javax.swing.* ;

import main.MazeController;

import java.awt.event.KeyEvent;

import ui.actionlisteners.*;

/**
 * <b>Classe représentant la barre de menu de la fenêtre</b>
 * <p>La barre de menu contient trois menu :
 * <ul>
 * <li>Fichier : Nouveau, Ouvrir, Enregistrer, Enregistrer Sous, Fermer, Quitter</li>
 * <li>Labyrinthe : Résoudre, Aléatoire, Effacer</li>
 * <li>Affichage : Thème, Tileset</li>
 * </ul>
 * </p>
 * <p>Les ActionListener sont les mêmes pour les boutons de ToolBar</p>
 * 
 * @see ToolBar
 * @see MazeController
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class MenuBar extends JMenuBar
{
	private static final long serialVersionUID = 2101817289107094333L;
	
	private final JMenu fileMenu, mazeMenu, showMenu;
	private final JMenuItem newItem, openItem, saveItem, saveAsItem, closeItem, quitItem;
	private final JMenuItem solveItem, randomItem, eraseItem;
	private final JMenuItem tilesetItem;
	private final JMenu styleMenu;
	
	/**
	 * Constructeur de MenuBar, crée les menu et les items de menu
	 * @param mazectrl instance de MazeController qui sera appelée en réaction aux clics.
	 */
	public MenuBar(MazeController mazectrl, Window window)
	{
		super() ;

		fileMenu = new JMenu("Fichier");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		newItem = new MenuItem("Nouveau", Window.icons.get("new"), KeyEvent.VK_N, new CreateMazeAction(mazectrl));
		fileMenu.add(newItem);
		
		openItem = new MenuItem("Ouvrir", Window.icons.get("open"), KeyEvent.VK_O, new OpenAction(mazectrl));
		fileMenu.add(openItem);
		
		saveItem = new MenuItem("Enregistrer", Window.icons.get("save"), KeyEvent.VK_S, new SaveAction(mazectrl));
		fileMenu.add(saveItem);
		
		saveAsItem = new MenuItem("Enregistrer sous", null, 0, new SaveAsAction(mazectrl));
		fileMenu.add(saveAsItem);
		
		closeItem = new MenuItem("Fermer", Window.icons.get("close"), KeyEvent.VK_C, new CloseAction(mazectrl));
		fileMenu.add(closeItem);
		
		quitItem = new MenuItem("Quitter", null, KeyEvent.VK_Q, new QuitAction(mazectrl));
		fileMenu.add(quitItem);
		
		add(fileMenu);
		
		mazeMenu = new JMenu("Labyrinthe");
		mazeMenu.setMnemonic(KeyEvent.VK_L);

		solveItem = new MenuItem("Résoudre", Window.icons.get("apply"), KeyEvent.VK_R, new SolveAction(mazectrl));
		mazeMenu.add(solveItem);


		randomItem = new MenuItem("Aléatoire", Window.icons.get("random"), 0, new SolveAction(mazectrl));
		mazeMenu.add(randomItem);


		eraseItem = new MenuItem("Effacer", Window.icons.get("clear"), 0, new SolveAction(mazectrl));
		mazeMenu.add(eraseItem);
		
		add(mazeMenu);
		
		showMenu = new JMenu("Affichage");
		showMenu.setMnemonic(KeyEvent.VK_A);
		
		styleMenu = new ThemesMenuItem(window);
		showMenu.add(styleMenu);
		
		tilesetItem = new MenuItem("Tileset", null, 0, new TileChooserAction(mazectrl, window));
		showMenu.add(tilesetItem);
		add(showMenu);
		
	}
	
}