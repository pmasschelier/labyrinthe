package dijkstra;

/**
 * <b>Interface d'un tas de VertexInterface utilisé par l'algorithme de Dijkstra</b>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
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
