package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	
	MBox(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.y;
	}
	
	public int getY() {
		return this.y;
	}
	
	// Coordonnées dans le labyrinthe
	private int x, y;
	// Référence vers le labyrinthe
	protected Maze maze;
}
