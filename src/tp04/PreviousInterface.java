package tp04;

public interface PreviousInterface {
	
	/**
	 * @param vertex Sommet dont on veut récupérer le père
	 * @return Père du sommet
	 */
	public VertexInterface getFather(VertexInterface vertex);
	
	/**
	 * @param son Sommet dont on veut modifier le père
	 * @param father Père du sommet
	 */
	public void setFather(VertexInterface son, VertexInterface father);
}
