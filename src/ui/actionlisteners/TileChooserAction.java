package ui.actionlisteners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MazeController;
import ui.Window;
import ui.tilechooser.TileChooserDialog;

public class TileChooserAction implements ActionListener {
	
	private final Window window;
	private final MazeController mazectrl;
	
	public TileChooserAction(MazeController mazectrl, Window window) {
		this.window = window;
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e) {
		new TileChooserDialog(mazectrl, window);
	}
}
