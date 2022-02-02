package dijkstra;

import java.util.ArrayList;


public final class Dijkstra {
	
	/** @brief Méthode statique implémentant l'algorithme de Dijkstra
	 * @param g Graphe sur lequel on veut executer l'algorithme
	 * @param r Racine du graphe
	 * @return HashMap de précédance pour chaque sommet du graphe
	 */
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r)  {
		Previous prev =  new Previous();
		PiInterface pi = new Pi();
		pi.setDistance(r, 0);
		Heap heap = new Heap(g.getVertices(), pi);
		
		while(!heap.empty()) {
			VertexInterface t = heap.pop();
			ArrayList<VertexInterface> neighbors = g.getNeighbors(t);
			for(VertexInterface n : neighbors) {
				if(heap.contains(n)) {
					int d = (pi.getDistance(t) < Integer.MAX_VALUE - g.getWeight(t, n)) ? pi.getDistance(t) + g.getWeight(t, n) : Integer.MAX_VALUE;
					if(pi.getDistance(n)  > d) {
						pi.setDistance(n, d);
						heap.updateDownward(n);
						prev.setFather(n, t);
					}
				}
			}
		}
		
		return prev;
	}
}
