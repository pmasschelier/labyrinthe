package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <b>Classe implementant HeapInterface</b>
 * La classe représente un tas (dans l'ordre décroissant) contenant des VertexInterface
 * 
 * @author masschelier@telecom-paris.fr
 */
public final class Heap implements HeapInterface {
	private ArrayList<VertexInterface> heap;
	HashMap<VertexInterface, Integer> indices;
	PiInterface pi;
	int length;
	
	/** @brief Constructeur de Heap
	 * @param args Liste de VertexInterface à ajouter au tas
	 * @param pi objet contentant la "valeur" de chaque sommet à ajouter
	 */
	public Heap(ArrayList<VertexInterface> args, PiInterface pi) {
		heap = new ArrayList<VertexInterface>(args);
		indices = new HashMap<VertexInterface, Integer>();
		length = heap.size();
		this.pi = pi;
		
		buildHeap();
	}
	
	/**
	 * @param i Indice de l'élément dans un tas dont on cherche le père
	 * @return Indice du père
	 */
	static private int father(int i) {
		return (i-1)/2;
	}
	
	/**
	 * @param k Indice de l'élément à faire remonter dans le tas en considérant [0, k-1] comme un tas
	 * @return nouvelle position de l'élément
	 */
	private int pullUp(int k) {
		int i = k;
		VertexInterface key = heap.get(i);
		
		while(i >= 1 && pi.getDistance(heap.get(father(i))) > pi.getDistance(key)) {
			VertexInterface f = heap.get(father(i));
			heap.set(i, f);
			indices.put(f, i);
			i = father(i);
		}
		heap.set(i, key);
		indices.put(key, i);
		return i;
	}
	
	
	/**
	 * @brief Construit un tas en faisant remonter les éléments un par un
	 */
	private void buildHeap() {
		for(int k = 1; k < length; k++)
			pullUp(k);
	}
	
	/** Renvoie l'indice du sommet ayant la plus grande pi-distance entre i et j
	 * @param k indice maximum
	 * @return max(i, j) ou -1 si i, j >= k
	 */
	private int max(int i, int j, int k) {
		if(i >= k && j >= k) return -1;
		if(i >= k) return j;
		if(j >= k) return i;
		if( pi.getDistance(heap.get(i)) > pi.getDistance(heap.get(j)) )
			return j;
		else
			return i;
	}
	
	/** @brief Échange deux éléments dans le tas
	 * @param i Indice du premier élément
	 * @param j Indice du second élément
	 */
	private void swap(int i, int j) {
		VertexInterface vi = heap.get(i);
		VertexInterface vj = heap.get(j);
		heap.set(i, vj);
		indices.put(vj, i);
		heap.set(j, vi);
		indices.put(vi, j);
	}
	
	/** Fait descendre un sommet dans le tas [0, k]
	 * @param i Indice de l'élément à faire descendre dans le tas
	 * @param k Indice du dernier élément du tas
	 * @return nouvelle position du sommet que l'on a déplacé
	 */
	private int pullDown(int i, int k) {
		int s = max(2*i+1, 2*i+2, k);
		if(s>=0 && pi.getDistance(heap.get(i)) > pi.getDistance(heap.get(s))) {
			swap(i, s);
			i = pullDown(s, k);
		}
		return i;
	}
	
	/** @brief Renvoie la racine du tas et reconstruit le tas
	 * @return Élément de plus faible "valeur"
	 */
	public VertexInterface pop() {
		swap(0, length - 1);
		VertexInterface v = heap.get(length-1);
		heap.remove(--length);
		indices.remove(v);
		if(length > 0) {
			int i = pullDown(0, length);
			indices.put(heap.get(i), i);
		}
		return v;
	}
	
	/**
	 * @return true ssi le tas contient vertex
	 */
	public boolean contains(VertexInterface vertex) {
		return indices.containsKey(vertex);
	}
	
	/**
	 * @return true ssi le tas est vide
	 */
	public boolean empty() {
		return length == 0;
	}
	
	/** Si la "valeur" d'un élément du tas a diminué on met à jour le tas en faisant remonter le sommet dans le tas
	 * @param v Sommet dont la "valeur" a changé
	 */
	public void updateDownward(VertexInterface v) {
		if(indices.containsKey(v)) {
			int i = pullUp(indices.get(v));
			indices.put(v, i);
		}
	}
}