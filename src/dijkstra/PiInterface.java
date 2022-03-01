package dijkstra;

/**
 * <b>Interface de la table de hashage utilisé pour stocker les distances
 * des sommets dans l'algorithme de Dijkstra</b>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
public interface PiInterface {
	
	/**
	 * @param vertex Sommet dont on veut connaitre la distance
	 * @return Distance de vertex
	 */
	public int getDistance(VertexInterface vertex);
	

	/**
	 * @param vertex Sommet dont on veut modifier la distance
	 * @param distance Nouvelle distance
	 */
	public void setDistance(VertexInterface vertex, int distance);
	
}