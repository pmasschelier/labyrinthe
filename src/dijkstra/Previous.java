package dijkstra;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Classe basée sur une HashMap servant à stocker la précédance pour chaque sommet
 * résultant de l'algorithme de Dijkstra
 */
public final class Previous implements PreviousInterface {
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
	
	public ArrayDeque<VertexInterface> getShortestPathTo(VertexInterface target) {
		ArrayDeque<VertexInterface> path = new ArrayDeque<>();
		
		VertexInterface current = target;
		while((current = getFather(current)) != null)
			path.addFirst(current);
		
		return path;
	}
}
