package ui;

import javax.swing.* ;

import controller.MazeController;
import ui.actionlisteners.CreateMazeAction;
import ui.actionlisteners.OpenAction;
import ui.actionlisteners.QuitAction;

public class MenuBar extends JMenuBar
{
	Window app;
	
	JMenu fileMenu;
	JMenuItem newItem, openItem, saveItem, saveAsItem, closeItem, quitItem;
	
	public MenuBar(Window app, MazeController mazectrl)
	{
		super() ;
		this.app = app;
		
		fileMenu = new JMenu("Fichier");
		
		newItem = new JMenuItem("Nouveau");
		newItem.addActionListener(new CreateMazeAction(mazectrl));
		fileMenu.add(newItem);
		
		openItem = new JMenuItem("Ouvrir");
		openItem.addActionListener(new OpenAction(mazectrl));
		fileMenu.add(openItem);
		
		saveItem = new JMenuItem("Enregistrer");
		fileMenu.add(saveItem);
		
		saveAsItem = new JMenuItem("Enregistrer sous");
		fileMenu.add(saveAsItem);
		
		closeItem = new JMenuItem("Fermer");
		fileMenu.add(closeItem);
		
		quitItem = new JMenuItem("Quitter");
		quitItem.addActionListener(new QuitAction(app));
		fileMenu.add(quitItem);
		
		add(fileMenu);
	}
}