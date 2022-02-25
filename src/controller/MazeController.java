package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;

import javax.swing.JOptionPane;

import dijkstra.*;
import maze.*;
import ui.*;

final public class MazeController {
	private Maze maze;
	private Window app;
	private DrawingPanel panel;
	private String filename = null;
	private boolean saved = true;
	private String currentBoxLabel = "W";
	
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
	
	public void setCurrentBox(String label) {
		currentBoxLabel = label;
	}
	
	public boolean newVoidMaze() {
		int height = 0;
		int width = 0;
		
		try {
			while (height <= 0 || height > 40) {
				String heightS = JOptionPane.showInputDialog(app, "Hauteur de votre labyrinthe ? (40 Max)", "Hauteur", JOptionPane.QUESTION_MESSAGE);
				height = Integer.parseInt(heightS);
			}
			while (width<=0 || height >40) {
				String widthS = JOptionPane.showInputDialog(app, "Largeur de votre labyrinthe ? (40 Max)", "Largeur", JOptionPane.QUESTION_MESSAGE);
				width = Integer.parseInt(widthS);
			}
			return newVoidMaze(width, height);
		}
		catch (Exception exc) {
			// Rien à faire, simplement on ne crée pas de nouveau labyrinthe
			return false;
		}
	}
	
	public boolean newVoidMaze(int width, int height) {
		if(!checkSaved())
			return false;
		
		maze = new Maze(width, height);
		updateMaze();
		saved = false;
		filename = null;
		
		return true;
	}
	
	public boolean newRandomMaze() {
		if(maze == null) {
			if(!newVoidMaze())
				return false;
		}
		else {
			if(!newVoidMaze(maze.getSizeX(), maze.getSizeY()))
				return false;
		}
		
		for(int i = 0; i < maze.getSizeX(); i++) {
			for(int j = 0; j < maze.getSizeY(); j++) {
				if(Math.random() > 0.5)
					maze.setBox(new WBox(i, j));
			}
		}
		saved = false;
		filename = null;
		updateMaze();
		
		return true;
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
		catch(FileNotFoundException e) {
			app.showError("Fichier non trouvé", e.getMessage());
		}
		catch(IOException e) {
			app.showError("Erreur de lecture", e.getMessage());
		}
		catch(MazeReadingException e) {
			app.showError("Erreur de format", e.getMessage());
		}
	}
	
	public void saveMaze() {
		if(maze != null) {
			if(hasFilename()) {
				try {
					maze.saveToTextFile(filename);
					saved = true;
				}
				catch(FileNotFoundException e) {
					app.showError("Erreur lors de l'écriture du fichier", e.getMessage());
				}
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
				try {
					maze.saveToTextFile(filename);
					saved = true;
				}
				catch(FileNotFoundException e) {
					app.showError("Erreur lors de l'écriture du fichier", e.getMessage());
				}
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
		panel.getDPMgr().setPath(null);
		panel.notifyForUpdate();
	}
	
	public void solve() {
		if(maze == null) {
			JOptionPane.showMessageDialog(app, "Aucun labyrinthe à résoudre", "Pas de labyrinthe", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(maze.getStart() == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas de départ", "Absence de départ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(maze.getEnd() == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas d'arrivée", "Absence d'arrivée", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		PreviousInterface prev = Dijkstra.dijkstra(maze, maze.getStart());
		System.out.println(maze.getStart().getX() + ", " + maze.getStart().getY());
		System.out.println(maze.getEnd().getX() + ", " + maze.getEnd().getY());
		if(prev.getFather(maze.getEnd()) == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas de solution", "Labyrinthe insoluble", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ArrayDeque<VertexInterface> path = prev.getShortestPathTo(maze.getEnd());
		
		panel.getDPMgr().setPath(path);
		panel.notifyForUpdate();
	}
	
	public void clickAt(int x, int y) {
		if(maze == null)
			return;
		
		int xi = x * maze.getSizeX() / panel.getWidth();
		int yi = y * maze.getSizeY() / panel.getHeight();
		
		switch(currentBoxLabel) {
		case "E":
			maze.setBox(new EBox(xi, yi));
			break;
		case "A":
			maze.setBox(new ABox(xi, yi));
			break;
		case "D":
			maze.setBox(new DBox(xi, yi));
			break;
		default:
			maze.setBox(new WBox(xi, yi));
			break;
		}

		panel.getDPMgr().setPath(null);
		panel.notifyForUpdate();
		saved = false;
	}
	
	public Maze getMaze() {
		return maze;
	}
}
