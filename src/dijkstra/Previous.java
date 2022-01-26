package dijkstra;

import java.util.HashMap;

/**
 * Classe basée sur une HashMap servant à stocker la précédance pour chaque sommet
 * résultant de l'algorithme de Dijkstra
 */
public class Previous implements PreviousInterface {
	private HashMap<VertexInterface, VertexInterface> prev;
	
	public Previous() {
		prev = new HashMap<VertexInterface, VertexInterface>();
	}
	
	public VertexInterface getFather(VertexInterface vertex) {
		return prev.get(vertex);
	}
	public void setFather(VertexInterface son, VertexInterface father) {
		prev.put(son,father);
	}
}
