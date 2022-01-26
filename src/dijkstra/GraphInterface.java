package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	
	/**
	 * @return Liste des sommets du graphe
	 */
	public ArrayList<VertexInterface> getVertices() ;
	
	/**
	 * @param vertex Sommet dont on veut les successeurs
	 * @return Liste des successeurs de vertex
	 */
	public ArrayList<VertexInterface> getNeighbors(VertexInterface v);
	
	/**
	 * @param src Départ de l'arête considérée
	 * @param dst Arrivée de l'arête considérée
	 * @return Poids de l'arête
	 */
	public int getWeight(VertexInterface a,VertexInterface b);
}
