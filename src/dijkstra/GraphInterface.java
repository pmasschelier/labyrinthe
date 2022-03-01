package dijkstra;

import java.util.ArrayList;

/**
 * <b>Interface d'un graphe sur lequel s'effectue l'algorithme de Dijkstra</b>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
public interface GraphInterface {
	
	/**
	 * Getter pour l'ensemble des sommets du graphe
	 * @return Liste des sommets du graphe
	 */
	public ArrayList<VertexInterface> getVertices() ;
	
	/**
	 * Renvoie l'ensemble des successeur du sommet v dans le graphe
	 * @param v Sommet dont on veut les successeurs
	 * @return Liste des successeurs de vertex
	 */
	public ArrayList<VertexInterface> getNeighbors(VertexInterface v);
	
	/**
	 * Renvoie le poids d'une arête dans le graphe
	 * @param a Départ de l'arête considérée
	 * @param b Arrivée de l'arête considérée
	 * @return Poids de l'arête
	 */
	public int getWeight(VertexInterface a,VertexInterface b);
}
