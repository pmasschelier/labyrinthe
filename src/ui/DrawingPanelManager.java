package ui;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import dijkstra.VertexInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

public class DrawingPanelManager {
	DrawingPanel panel;
	Maze maze = null;
	ArrayDeque<VertexInterface> path = null;
	
	static final HashMap<String, Color> tilesColors;
	
	static {
		tilesColors = new HashMap<String, Color>();
		tilesColors.put("A", Color.YELLOW);
		tilesColors.put("D", Color.BLUE);
		tilesColors.put("W", Color.BLACK);
		tilesColors.put("E", Color.WHITE);
	}
	
	
	DrawingPanelManager(DrawingPanel panel) {
		this.panel = panel;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
	public void setPath(ArrayDeque<VertexInterface> path) {
		this.path = path;
	}
	
	public void paintAllTiles(Graphics g) {		
		if(maze == null)
			return;
		int w = panel.getWidth() / maze.getSizeX();
		int h = panel.getHeight() / maze.getSizeY();
		
		for(VertexInterface box : maze.getVertices()) {
			g.setColor(tilesColors.get(box.getLabel()));
			g.fillRect(box.getX() * w, box.getY() * h, w, h);
		}
	}
	
	public void paintPath(Graphics g) {
		if(path != null && maze != null) {
			int w = panel.getWidth() / maze.getSizeX();
			int h = panel.getHeight() / maze.getSizeY();
		
			g.setColor(Color.RED);
			for(VertexInterface coord : path) {
				g.fillRect(coord.getX() * w, coord.getY() * h, w, h);
			}
		}
	}
}
