package ui;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;

/**
 * <b>Classe représentant les items de menu</b>
 * <p>Cette classe permet d'instancier en une ligne un item de menu
 * en fournissant son nom, son icon (ou null), sa mnemonic (ex : KeyEvent.VK_E ou 0),
 * son ActionListener (ou null)</p>
 * 
 * @see MenuBar
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class MenuItem extends JMenuItem {

	private static final long serialVersionUID = 3988784812932281610L;
	
	public MenuItem(String title, Icon icon, int mnemonic, ActionListener action) {
		super(title, icon);
		if(mnemonic != 0)
			setMnemonic(mnemonic);
		if(action != null)
			addActionListener(action);
	}
	
}
