package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.Window;

import javax.swing.UIManager;

public class ChangeThemeAction implements ActionListener {
	UIManager.LookAndFeelInfo info;
	Window app;
	
	public ChangeThemeAction(UIManager.LookAndFeelInfo info, Window app) {
		this.info = info;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			UIManager.setLookAndFeel(info.getClassName());
			SwingUtilities.updateComponentTreeUI(app);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			app.showError("Thème non supporté", e1.getMessage());
		}
	}
}
