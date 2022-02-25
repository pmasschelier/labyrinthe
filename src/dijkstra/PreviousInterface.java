package dijkstra;

import java.util.ArrayDeque;
import java.util.ArrayList;

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
	
	/**
	 * @param target Cible vers laquelle ont veut trouver un chemin
	 * @return Liste des sommets jusqu'à target (point d'arrivée exclus, point de départ inclus)
	 */
	public ArrayDeque<VertexInterface> getShortestPathTo(VertexInterface target);
}
