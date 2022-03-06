	package maze;

import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <b>Classe représentant le labyrinthe en tant que structure de donnée</b>
 * <p>Le labyrinthe est essentiellement constituée d'un ArrayList de MBox
 * arrangée d'abord par ligne puis par colonne. Le labyrinthe se charge de 
 * conserver sa propre cohérence notamment en mettant à jour ses attribut start
 * et end qui doivent référencer respectivement l'unique DBox et l'unique ABox
 * de vertices.</p>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
public final class Maze implements GraphInterface {

	int sizeX, sizeY;
	ArrayList<MBox> vertices;
	DBox start;
	ABox end;
	
	
	/**
	 * Constructeur par défaut de Maze
	 * Le labyrinthe créé est de taille nulle
	 */
	public Maze() {
		vertices = new ArrayList<>();
		sizeX = 0;
		sizeY = 0;
	}
	
	/**
	 * Crée un labyrinthe vide de la taille spécifiée
	 * @param width Largeur du labyrinthe
	 * @param height Hauteur du labyrinthe
	 * @see Maze#createEmpty(int, int)
	 */
	public Maze(int width, int height) {
		createEmpty(width, height);
	}
	
	/**
	 * Crée un labyrinthe vide de la taille spécifiée
	 * @param width Largeur du labyrinthe
	 * @param height Hauteur du labyrinthe
	 */
	public void createEmpty(int width, int height) {
		this.vertices = new ArrayList<>(width * height);
		this.sizeX = width;
		this.sizeY = height;
		
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				vertices.add(new EBox(i, j));
			}
		}
	}
	
	
	/**
	 * Charge le labyrinthe depuis un fichier texte.
	 * Lit le fichier ligne par ligne puis les lignes caractère par caractère pour initialiser les propriétés
	 * @param filename Chemin vers le fichier depuis lequel charger le labyrinthe
	 * @throws MazeReadingException Si toutes les lignes n'ont pas la même taille ou qu'un caractère est inconnu.
	 */
	public final void loadFromFile(String filename) throws FileNotFoundException, IOException, MazeReadingException {
		BufferedReader in = null;
		ArrayList<MBox> verticestmp = new ArrayList<>();
		DBox starttmp = null;
		ABox endtmp = null;
		
		in = new BufferedReader(new FileReader(filename));
		int i = 0;
		boolean firstLine = true;
		
		int sizeLine = 0;

		String line;
		
		while ((line = in.readLine()) != null)
		{
			int length = line.length();
			if(firstLine)
				sizeLine = length;
			else {
				if(length != sizeLine) {
					in.close();
					throw new MazeReadingException(filename, i, "Nombre de colonnes incorrect");
				}
			}
			for(int j = 0; j < sizeLine; j++) {
				switch (line.charAt(j)) {
				case 'A' :
					if(endtmp != null) {
						in.close();
						throw new MazeReadingException(filename, i-1, "Plusieurs arrivées trouvées");
					}
					endtmp = new ABox(j, i);
					verticestmp.add(endtmp);
					break;
				case 'E' :
					verticestmp.add(new EBox(j, i));
					break;
				case 'W' :
					verticestmp.add(new WBox(j, i));
					break;
				case 'D' :
					if(starttmp != null) {
						in.close();
						throw new MazeReadingException(filename, i-1, "Plusieurs départs trouvés");
					}
					starttmp = new DBox(j, i);
					verticestmp.add(starttmp);
					break;
				default :
					in.close();
					throw new MazeReadingException(filename, i-1, "Caractère non reconnu");
				}
			}
			i++;
			firstLine = false;
		}
		in.close();
		
		sizeX = sizeLine;
		sizeY = i;
		vertices = verticestmp;
		start = starttmp;
		end = endtmp;

	}
	
	/** Enregistre le labyrinthe dans un fichier
	 * @param filename Nom du fichier dans lequel sauvegarder
	 */
	public void saveToTextFile(String filename) throws FileNotFoundException {
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
	
	
	/** Renvoie la liste des voisin de v
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
	
	
	/** Renvoie le poids de l'arête entre deux VertexInterface voisins dans le graphe.
	 *	La fonction renvoie toujours 1 car les voisins sont tous à une distance de 1 dans un labyrinthe.
	 *	@return 1
	 */
	public int getWeight(VertexInterface a,VertexInterface b) {
		return 1;
	}
	
	/** Renvoie le tableau des sommets du graphe.
	 * @return Liste des vertex ordonnées par lignes puis par colonnes
	 */
	public ArrayList<VertexInterface> getVertices() {
		return new ArrayList<VertexInterface>(vertices);
	}
	
	/** Renvoie le tableau des cases du labyrinthe.
	 * @return Liste des boites ordonnées par lignes puis par colonnes
	 */
	public ArrayList<MBox> getBoxes() {
		return vertices;
	}
	
	/**
	 * Renvoie la boite située aux coordonées spécifiée.
	 * @param x numéro de la colonne
	 * @param y numéro de la ligne
	 * @return Boite situé à ces coordonnées
	 */
	public MBox getBox(int x, int y) {
		return vertices.get(y * sizeX + x);
	}
	
	private boolean place(MBox box) {
		if(start != null && box.getX() == start.getX() && box.getY() == start.getY())
			start = null;
		if(end != null && box.getX() == end.getX() && box.getY() == end.getY())
			end = null;
		if(box.getX() < 0 || box.getX() >= sizeX || box.getY() < 0 || box.getY() >= sizeY)
			return false;
		vertices.set(box.getY() * sizeX + box.getX(), box);
		return true;
	}

	/**
	 * Place une DBox dans le labyrinthe, les coordonnées auxquelles elle doit
	 * être placée est embarquée dans box.
	 * La case qui prenait sa place précédemment est écrasée.
	 * L'ancien départ s'il existait est remplacée par une EBox
	 * @param box case à mettre dans le labyrinthe
	 * @return true ssi la boite a pu être placée
	 * @see Maze#setBox(ABox)
	 * @see Maze#setBox(EBox)
	 * @see Maze#setBox(WBox)
	 */
	public boolean setBox(DBox box) {
		boolean ret = place(box);
		if(start != null)
			ret &= place(new EBox(start.getX(), start.getY()));
		start = box;
		return ret;
	}

	/**
	 * Place une ABox dans le labyrinthe, les coordonnées auxquelles elle doit
	 * être placée est embarquée dans box.
	 * La case qui prenait sa place précédemment est écrasée.
	 * L'ancienne arrivée si elle existait est remplacée par une EBox
	 * @param box case à mettre dans le labyrinthe
	 * @return true ssi la boite a pu être placée
	 * @see Maze#setBox(DBox)
	 * @see Maze#setBox(EBox)
	 * @see Maze#setBox(WBox)
	 */
	public boolean setBox(ABox box) {
		boolean ret = place(box);
		if(end != null)
			ret &= place(new EBox(end.getX(), end.getY()));
		end = box;
		return ret;
	}

	/**
	 * Place une EBox dans le labyrinthe, les coordonnées auxquelles elle doit
	 * être placée est embarquée dans box
	 * La case qui prenait sa place précédemment est écrasée.
	 * @param box case à mettre dans le labyrinthe
	 * @return true ssi la boite a pu être placée
	 * @see Maze#setBox(ABox)
	 * @see Maze#setBox(DBox)
	 * @see Maze#setBox(WBox)
	 */
	public boolean setBox(EBox box) {
		return place(box);
	}

	/**
	 * Place une WBoc dans le labyrinthe, les coordonnées auxquelles elle doit
	 * être placée est embarquée dans box.
	 * La case qui prenait sa place précédemment est écrasée.
	 * @param box case à mettre dans le labyrinthe
	 * @return true ssi la boite a pu être placée
	 * @see Maze#setBox(ABox)
	 * @see Maze#setBox(DBox)
	 * @see Maze#setBox(EBox)
	 */
	public boolean setBox(WBox box) {
		return place(box);
	}
	
	/**
	 * Getter pour la largeur du labyrinthe.
	 * @return Largeur du labyrinthe
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * Getter pour la hauteur du labyrinthe.
	 * @return Hauteur du labyrinthe
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * Getter pour le départ du labyrinthe.
	 * @return Départ du labyrinthe
	 */
	public VertexInterface getStart() {
		return start;
	}
	/**
	 * Getter pour l'arrivée du labyrinthe.
	 * @return Arrivée du labyrinthe
	 */
	public VertexInterface getEnd() {
		return end;
	}
	
	/**
	 * Renvoie un tableau de char représentant le labyrinthe afin de l'afficher.
	 * @return Tableau de char à 2 dimensions représentant le labyrinthe
	 */
	public char[][] toChars() {
		char tab[][] = new char[sizeY][sizeX];
		for(VertexInterface v : vertices)
			tab[v.getY()][v.getX()] = v.getLabel().charAt(0);
		return tab;
	}
	
}

