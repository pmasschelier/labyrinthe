package controller;

import maze.EBox;
import maze.Maze;
import maze.MazeReadingException;
import ui.DrawingPanel;
import ui.DrawingPanelMouseListener;
import ui.Window;

public class MazeController {
	Maze maze;
	DrawingPanel panel;
	
	public MazeController() {
		
	}
	
	public void setDrawingPanel(DrawingPanel panel) {
		this.panel = panel;
		panel.getDPMgr().setMaze(maze);
		DrawingPanelMouseListener mouseListener = new DrawingPanelMouseListener(this);
		panel.addMouseListener(mouseListener);
		panel.addMouseMotionListener(mouseListener);
	}
	
	public void newVoidMaze(int width, int height) {
		if(maze == null) {
			maze = new Maze(width, height);
			panel.getDPMgr().setMaze(maze);
		}
		else
			maze.createEmpty(width, height);
		panel.notifyForUpdate();
	}
	
	public void openMaze(String filename) {
		try {
			if(maze == null) {
				maze = new Maze();
				panel.getDPMgr().setMaze(maze);
			}
			maze.loadFromFile(filename);
			panel.notifyForUpdate();
		}
		catch (MazeReadingException e) {
			
		}
	}
	
	public void clickAt(int x, int y) {
		if(maze != null)
			maze.setBox(new EBox(x / panel.getWidth(), y / panel.getHeight()));
	}
}
