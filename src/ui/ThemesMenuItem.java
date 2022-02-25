package ui;

import javax.swing.* ;

import ui.actionlisteners.ChangeThemeAction;

final public class ThemesMenuItem extends JMenu {
	
	private static final long serialVersionUID = 5576535944802200870L;

	ThemesMenuItem(Window app) {
		super("Thème");
		
		ButtonGroup group = new ButtonGroup();
		
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo look : looks) {
			
			if(look.getClassName().equals("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")) // Ce thème fait crasher l'app
				continue;
				
			JRadioButtonMenuItem menuitem = new JRadioButtonMenuItem(look.getName());
			menuitem.addActionListener(new ChangeThemeAction(look, app));
			group.add(menuitem);
			add(menuitem);
		}
	}
	
	
}
