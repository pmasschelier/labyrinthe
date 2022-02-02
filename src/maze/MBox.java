package maze;

import dijkstra.VertexInterface;

/**
 * Class abstraite implémentant VertexInterface
 * Représente une case du labyrinthe
 */
public abstract class MBox implements VertexInterface {
	
	MBox(String label, boolean accessible, int x, int y) {
		this.label = new String(label);
		this.accessible = accessible;
		this.x = x;
		this.y = y;
	}
	
	public final int getX() {
		return x;
	}
	
	public final  int getY() {
		return y;
	}
	
	public final String getLabel() {
		return label;
	}
	
	public final boolean isAccessible() {
		return accessible;
	}
	
	// Coordonnées dans le labyrinthe
	private int x, y;
	// Nom de la case
	private String label;
	// La case peut-elle être traversée
	private boolean accessible;
}
