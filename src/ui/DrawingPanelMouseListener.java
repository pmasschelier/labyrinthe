package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.MazeController;
import maze.EBox;
import maze.Maze;

final public class DrawingPanelMouseListener extends MouseAdapter {
	
	final MazeController mazectrl;
	
	public DrawingPanelMouseListener(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}
	
	public void mouseClicked(MouseEvent e) {
		mazectrl.clickAt(e.getX(), e.getY());
	}
	
	public void mouseDragged(MouseEvent e) {
		mazectrl.clickAt(e.getX(), e.getY());
	}
}
