package maze;

import dijkstra.VertexInterface;

/**
 * Class abstraite implémentant VertexInterface
 * Représente une case du labyrinthe
 */
public abstract class MBox implements VertexInterface {
	
	MBox(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	// Coordonnées dans le labyrinthe
	private int x, y;
	// Référence vers le labyrinthe
	protected Maze maze;
}
