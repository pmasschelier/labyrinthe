package ui;

import javax.swing.* ;

import controller.MazeController;
import ui.actionlisteners.*;

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
		openItem.addActionListener(new OpenAction(mazectrl, app));
		fileMenu.add(openItem);
		
		saveItem = new JMenuItem("Enregistrer");
		saveItem.addActionListener(new SaveAction(mazectrl, app));
		fileMenu.add(saveItem);
		
		saveAsItem = new JMenuItem("Enregistrer sous");
		saveAsItem.addActionListener(new SaveAsAction(mazectrl, app));
		fileMenu.add(saveAsItem);
		
		closeItem = new JMenuItem("Fermer");
		closeItem.addActionListener(new CloseAction(mazectrl, app));
		fileMenu.add(closeItem);
		
		quitItem = new JMenuItem("Quitter");
		quitItem.addActionListener(new QuitAction(mazectrl, app));
		fileMenu.add(quitItem);
		
		add(fileMenu);
	}
}