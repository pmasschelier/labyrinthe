package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import maze.EBox;
import maze.Maze;
import maze.MazeReadingException;
import ui.DrawingPanel;
import ui.DrawingPanelMouseListener;
import ui.Window;
import ui.actionlisteners.SaveAction;

public class MazeController {
	Maze maze;
	Window app;
	DrawingPanel panel;
	String filename = null;
	boolean saved = true;
	
	public MazeController() {
		app = new Window(this);
		panel = app.getDrawingPanel();
	}
	
	public void setDrawingPanel(DrawingPanel panel) {
		this.panel = panel;
		panel.getDPMgr().setMaze(maze);
		DrawingPanelMouseListener mouseListener = new DrawingPanelMouseListener(this);
		panel.addMouseListener(mouseListener);
		panel.addMouseMotionListener(mouseListener);
	}
	
	public void newVoidMaze(int width, int height) {
		maze = new Maze(width, height);
		updateMaze();
		saved = false;
		filename = null;
	}
	
	public void openMaze(String filename) {
		try {
			if(maze == null)
				maze = new Maze();
			maze.loadFromFile(filename);
			this.filename = filename;
			updateMaze();
			saved = true;
			
		}
		catch (MazeReadingException e) {
			
		}
	}
	
	public void saveMaze() {
		if(maze != null) {
			if(hasFilename()) {
				maze.saveToTextFile(filename);
				saved = true;
			}
			else
				filename = saveAsMaze();
		}
	}
	
	public String saveAsMaze() {
		String filename = null;
		
		if(maze != null) {
			filename = app.getFilename("Enregistrer Sous");
			
			if(filename != null) {
				maze.saveToTextFile(filename);
				saved = true;
			}
		}
		
		return filename;
	}
	
	public void closeMaze() {
		maze = null;
		filename = null;
		saved = true;
		updateMaze();
	}
	
	public boolean hasFilename() {
		return filename != null;
	}

	public boolean isSaved() {
		return saved;
	}
	
	public boolean checkSaved() {
		if(!isSaved()) {
			int answer = JOptionPane.showConfirmDialog(app, "Voulez-vous enregistrer le labyrinthe avant de le fermer ?");
			if (answer == JOptionPane.YES_OPTION){
				 saveMaze();
			}
			return answer != JOptionPane.CANCEL_OPTION;
		}
		return true;
	}
	
	public void updateMaze() {
		panel.getDPMgr().setMaze(maze);
		panel.notifyForUpdate();
	}
	
	public void clickAt(int x, int y) {
		if(maze != null)
			maze.setBox(new EBox(x / panel.getWidth(), y / panel.getHeight()));
	}
}
