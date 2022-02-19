package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

public class DrawingPanelManager {
	DrawingPanel panel;
	Maze maze = null;
	
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
	
	public void paintAllTiles(Graphics g) {
		if(maze == null)
			return;
		int w = panel.getWidth() / maze.getSizeX();
		int h = panel.getHeight() / maze.getSizeY();
		
		for(MBox box : maze.getBoxes()) {
			g.setColor(tilesColors.get(box.getLabel()));
			g.fillRect(box.getX() * w, box.getY() * h, w, h);
		}
	}
}
