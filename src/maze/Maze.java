package maze;

import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public final class Maze implements GraphInterface {

	int sizeX, sizeY;
	ArrayList<MBox> vertices;
	MBox start, end;
	
	
	public Maze() {
		this.vertices = new ArrayList<>();
		this.sizeX = 0;
		this.sizeY = 0;
	}
	
	
	/**
	 * @brief Charge le labyrinthe depuis un fichier texte
	 * Lit le fichier ligne par ligne puis les lignes caractère par caractère pour initialiser les propriétés
	 * @param filename Chemin vers le fichier depuis lequel charger le labyrinthe
	 * @throws MazeReadingException Si toutes les lignes n'ont pas la même taille ou qu'un caractère est inconnu.
	 */
	public final void loadFromFile(String filename) throws  MazeReadingException {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(filename));
			int i = 0;
			boolean firstLine = true;
			boolean startSet = false;
			boolean endSet = false;
			

			String line;
			
			while ((line = in.readLine()) != null)
			{
				int length = line.length();
				if(firstLine)
					sizeX = length;
				else {
					if(length != sizeX)
						throw new MazeReadingException(filename, i, "Incorrect number of columns");
				}
				for(int j = 0; j < sizeX; j++) {
					MBox box = null;
					switch (line.charAt(j)) {
					case 'A' :
						if(endSet)
							throw new MazeReadingException(filename, i-1, "Multiple arrivals found");
						box = new ABox(j, i);
						end = box;
						endSet = true;
						vertices.add(box);
						break;
					case 'E' :
						box = new EBox(j, i);
						this.vertices.add(box);
						break;
					case 'W' :
						box = new WBox(j, i);
						vertices.add(box);
						break;
					case 'D' :
						if(startSet)
							throw new MazeReadingException(filename, i-1, "Multiple departures found");
						box = new DBox(j, i);
						start = box;
						startSet = true;
						vertices.add(box);
						break;
					default :
						throw new MazeReadingException(filename, i-1, "Unknow letter box");
					}
				}
				i++;
				firstLine = false;
			}
			sizeY = i;
		}
		catch(FileNotFoundException e) {
			System.out.println("Error : " + e);
		}
		catch (IOException e) {
			System.out.println("Error : " + e);
		}
		finally {
			try {
				in.close();
			}
			catch (IOException e) {
				System.out.println("Error : " + e);
			}
		}
	}
	
	/** @brief Enregistre le labyrinthe dans un fichier
	 * @param filename Nom du fichier dans lequel sauvegarder
	 */
	public void saveToTextFile(String filename) {
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(filename);
			
			int n = 1;
			for(VertexInterface v : this.vertices) {
				writer.print(v.getLabel());
				
				if(n++ % sizeX == 0)
					writer.print('\n');
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error : " + e);
		}
		finally {
			writer.close();
		}
		
		
	}
	
	
	/** @brief Renvoie la liste des voisin de v
	 * Test si les voisins directs ne sont pas des murs, auquel cas on les ajoute à la liste
	 * @param v VertexInterface dont on cherche les voisins dans le graphe
	 * @return Liste des voisins
	 */
	public ArrayList<VertexInterface> getNeighbors(VertexInterface v) {
		int i = v.getX(), j = v.getY();
		int n = i + sizeX * j;
		ArrayList<VertexInterface> neighbors = new ArrayList<VertexInterface>();
		
		int index;
		index = n-1;
		if(i > 0 && this.vertices.get(index).isAccessible())
			neighbors.add(this.vertices.get(index));
		
		index = n+1;
		if(i < this.sizeX - 1 && this.vertices.get(index).isAccessible()) 
			neighbors.add(this.vertices.get(index));
		
		index = n-this.sizeX;
		if(j > 0 && this.vertices.get(index).isAccessible())
			neighbors.add(this.vertices.get(index));
		
		index = n + this.sizeX;
		if(j < this.sizeY - 1 && this.vertices.get(index).isAccessible())
			neighbors.add(this.vertices.get(index));
		
		return neighbors;
	}
	
	
	/** @brief Renvoie le poids de l'arête entre deux VertexInterface voisins dans le graphe
	 *	La fonction renvoie toujours 1 car les voisins sont tous à une distance de 1 dans un labyrinthe
	 *	@return 1
	 */
	public int getWeight(VertexInterface a,VertexInterface b) {
		return 1;
	}
	
	/** @brief Renvoie le tableau des sommets du graphe
	 * @return Liste des vertex ordonnées par lignes puis par colonnes
	 */
	public ArrayList<VertexInterface> getVertices() {
		return new ArrayList<VertexInterface>(vertices);
	}

	/**
	 * @return Départ du labyrinthe
	 */
	public VertexInterface getStart() {
		return start;
	}
	/**
	 * @return Arrivée du labyrinthe
	 */
	public VertexInterface getEnd() {
		return end;
	}
	
	/**
	 * @return Tableau de char à 2 dimensions représentant le labyrinthe
	 */
	public char[][] toChars() {
		char tab[][] = new char[sizeY][sizeX];
		for(VertexInterface v : vertices)
			tab[v.getY()][v.getX()] = v.getLabel().charAt(0);
		return tab;
	}
	
}

