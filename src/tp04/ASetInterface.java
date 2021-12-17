package tp04;

/**
 * @author tintin
 *
 */
public interface ASetInterface {
	
	/**
	 * @brief Ajoute un sommet à A
	 * @param vertex Sommet à ajouter
	 */
	public void addVertex(VertexInterface vertex);
	
	/**
	 * @brief Teste si un sommet est dans A
	 * @param vertex Sommet à chercher
	 * @return true ssi le sommet est dans A
	 */
	public boolean exists(VertexInterface vertex);
	
	
}
