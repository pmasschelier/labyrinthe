package maze;

import dijkstra.VertexInterface;

/**
 * <b>Classe abstraite implémentant VertexInterface</b>
 * Représente une case du labyrinthe
 * 
 * @author masschelier@telecom-paris.fr
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
	
	/**
	 * Renvoie vrai si la case est traversable
	 * @return accessible
	 */
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
