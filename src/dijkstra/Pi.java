package dijkstra;

import java.util.HashMap;

/**
 * Classe basée sur une HashMap servant à indiquer la distance d'un sommet 
 * pour l'algorithme de Dijkstra
 */
public class Pi implements PiInterface {
	private HashMap<VertexInterface, Integer> pi;
	
	public Pi() {
		pi = new HashMap<VertexInterface, Integer>();
	}
	
	public int getDistance(VertexInterface vertex) {
		if(!pi.containsKey(vertex))
			return Integer.MAX_VALUE;
		return pi.get(vertex);
	}
	
	
	public void setDistance(VertexInterface vertex, int distance) {
		pi.put(vertex, distance);
	}
	
}
