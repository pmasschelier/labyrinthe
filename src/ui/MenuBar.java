package ui;

import javax.swing.* ;
import java.awt.event.KeyEvent;

import controller.MazeController;
import ui.actionlisteners.*;

final public class MenuBar extends JMenuBar
{
	private final Window app;
	
	private final JMenu fileMenu, mazeMenu, showMenu;
	private final JMenuItem newItem, openItem, saveItem, saveAsItem, closeItem, quitItem;
	private final JMenuItem solveItem, randomItem, eraseItem;
	private final JMenuItem tilesetItem;
	private final JMenu styleMenu;
	
	public MenuBar(Window app, MazeController mazectrl)
	{
		super() ;
		this.app = app;
		
		fileMenu = new JMenu("Fichier");
		
		newItem = new JMenuItem("Nouveau");
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.addActionListener(new CreateMazeAction(mazectrl));
		fileMenu.add(newItem);
		
		openItem = new JMenuItem("Ouvrir");
		openItem.setMnemonic(KeyEvent.VK_O);
		openItem.addActionListener(new OpenAction(mazectrl, app));
		fileMenu.add(openItem);
		
		saveItem = new JMenuItem("Enregistrer");
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.addActionListener(new SaveAction(mazectrl, app));
		fileMenu.add(saveItem);
		
		saveAsItem = new JMenuItem("Enregistrer sous");
		saveAsItem.addActionListener(new SaveAsAction(mazectrl, app));
		fileMenu.add(saveAsItem);
		
		closeItem = new JMenuItem("Fermer");
		closeItem.setMnemonic(KeyEvent.VK_C);
		closeItem.addActionListener(new CloseAction(mazectrl, app));
		fileMenu.add(closeItem);
		
		quitItem = new JMenuItem("Quitter");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.addActionListener(new QuitAction(mazectrl, app));
		fileMenu.add(quitItem);
		
		add(fileMenu);
		
		mazeMenu = new JMenu("Labyrinthe");

		solveItem = new JMenuItem("Résoudre");
		solveItem.setMnemonic(KeyEvent.VK_R);
		solveItem.addActionListener(new SolveAction(mazectrl));
		mazeMenu.add(solveItem);

		randomItem = new JMenuItem("Aléatoire");
		randomItem.addActionListener(new CreateRandomMazeAction(mazectrl));
		mazeMenu.add(randomItem);

		eraseItem = new JMenuItem("Effacer");
		eraseItem.addActionListener(new EraseAction(mazectrl));
		mazeMenu.add(eraseItem);
		
		add(mazeMenu);
		
		showMenu = new JMenu("Affichage");
		
		styleMenu = new ThemesMenuItem(app);
		showMenu.add(styleMenu);
		
		tilesetItem = new JMenuItem("Thème");
		showMenu.add(tilesetItem);
		add(showMenu);
		
	}
	
}