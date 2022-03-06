package ui;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;

public class MenuItem extends JMenuItem {

	private static final long serialVersionUID = 3988784812932281610L;
	
	public MenuItem(String title, Icon icon, int mnemonic, ActionListener action) {
		super(title, icon);
		if(mnemonic != 0)
			setMnemonic(mnemonic);
		if(action != null)
			addActionListener(action);
	}
	
}
