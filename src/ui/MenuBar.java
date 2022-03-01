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
	public MenuBar(MazeController mazectrl)
	{
		super() ;

		fileMenu = new JMenu("Fichier");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		newItem = new JMenuItem("Nouveau", Window.icons.get("new"));
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.addActionListener(new CreateMazeAction(mazectrl));
		fileMenu.add(newItem);
		
		openItem = new JMenuItem("Ouvrir", Window.icons.get("open"));
		openItem.setMnemonic(KeyEvent.VK_O);
		openItem.addActionListener(new OpenAction(mazectrl));
		fileMenu.add(openItem);
		
		saveItem = new JMenuItem("Enregistrer", Window.icons.get("save"));
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.addActionListener(new SaveAction(mazectrl));
		fileMenu.add(saveItem);
		
		saveAsItem = new JMenuItem("Enregistrer sous");
		saveAsItem.addActionListener(new SaveAsAction(mazectrl));
		fileMenu.add(saveAsItem);
		
		closeItem = new JMenuItem("Fermer", Window.icons.get("close"));
		closeItem.setMnemonic(KeyEvent.VK_C);
		closeItem.addActionListener(new CloseAction(mazectrl));
		fileMenu.add(closeItem);
		
		quitItem = new JMenuItem("Quitter");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.addActionListener(new QuitAction(mazectrl));
		fileMenu.add(quitItem);
		
		add(fileMenu);
		
		mazeMenu = new JMenu("Labyrinthe");
		mazeMenu.setMnemonic(KeyEvent.VK_L);

		solveItem = new JMenuItem("Résoudre", Window.icons.get("apply"));
		solveItem.setMnemonic(KeyEvent.VK_R);
		solveItem.addActionListener(new SolveAction(mazectrl));
		mazeMenu.add(solveItem);

		randomItem = new JMenuItem("Aléatoire", Window.icons.get("random"));
		randomItem.addActionListener(new CreateRandomMazeAction(mazectrl));
		mazeMenu.add(randomItem);

		eraseItem = new JMenuItem("Effacer", Window.icons.get("clear"));
		eraseItem.addActionListener(new EraseAction(mazectrl));
		mazeMenu.add(eraseItem);
		
		add(mazeMenu);
		
		showMenu = new JMenu("Affichage");
		showMenu.setMnemonic(KeyEvent.VK_A);
		
		styleMenu = new ThemesMenuItem(mazectrl.getWindow());
		showMenu.add(styleMenu);
		
		tilesetItem = new JMenuItem("Tileset");
		showMenu.add(tilesetItem);
		add(showMenu);
		
	}
	
}