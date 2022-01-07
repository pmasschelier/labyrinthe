package dijkstra;

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