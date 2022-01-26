package dijkstra;

public interface HeapInterface {
	
	public VertexInterface pop();
	
	/**
	 * @brief Teste si un sommet est dans A
	 * @param vertex Sommet à chercher
	 * @return true ssi le sommet est dans A
	 */
	public boolean contains(VertexInterface vertex);
	
	public boolean empty();
	
	
}
