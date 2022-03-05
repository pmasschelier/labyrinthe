package ui;

import java.util.ArrayDeque;
import java.util.HashMap;

import dijkstra.VertexInterface;

import java.awt.Color;
import java.awt.Graphics;

import maze.Maze;

/**
 * <b>DrawingPanelManager est la classe chargée de dessiner sur le DrawingPanel</b>
 * <p>La classe contient les méthodes pour dessiner le labyrinthe ainsi que le chemin
 * sur le drawing panel</p>
 * <p>La classe définit une hashmap statique pour définir la couleur de chaque case.</p>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class DrawingPanelManager {
	
	private final DrawingPanel panel;
	private Maze maze = null;
	private ArrayDeque<VertexInterface> path = null;
	
	private final HashMap<String, Color> tilesColors;

	public DrawingPanelManager(DrawingPanel panel) {
		this.panel = panel;
		
		tilesColors = new HashMap<String, Color>();
		tilesColors.put("A", Color.YELLOW);
		tilesColors.put("D", Color.BLUE);
		tilesColors.put("W", Color.BLACK);
		tilesColors.put("E", Color.WHITE);
		tilesColors.put(".", Color.RED);
	}
	
	public HashMap<String, Color> getTilesColors() {
		return tilesColors;
	}
	
	/**
	 * @param maze Nouveau labyrinthe à dessiner
	 */
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
	/**
	 * @param path Nouveau chemin à dessiner (en rouge)
	 * On passe path = null pour ne plus dessiner de chemin
	 */
	public void setPath(ArrayDeque<VertexInterface> path) {
		this.path = path;
	}
	
	/**
	 * Dessine le labyrinthe sur le DrawingPanel à partir des couleur définies
	 * dans tilesColors
	 * @param g instance de Graphics passée par l'instance de DrawingPanel
	 */
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
	
	/**
	 * Dessine le chemin en rouge sur le DrawingPanel
	 * @param g instance de Graphics passée par l'instance de DrawingPanel
	 */
	public void paintPath(Graphics g) {
		if(path != null && maze != null) {
			int w = panel.getWidth() / maze.getSizeX();
			int h = panel.getHeight() / maze.getSizeY();
		
			g.setColor(tilesColors.get("."));
			boolean first = true;
			for(VertexInterface coord : path) {
				if(first) {
					first = false;
					continue;
				}
				g.fillRect(coord.getX() * w, coord.getY() * h, w, h);
			}
		}
	}
}
