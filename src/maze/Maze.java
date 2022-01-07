package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class Maze implements GraphInterface {
	
	public Maze() {
		this.vertices = new ArrayList<>();
		this.sizeX = 0;
		this.sizeY = 0;
	}
	
	
	/**
	 * @brief Charge le labyrinthe depuis un fichier texte
	 * @param filename Chemin vers le fichier depuis lequel charger le labyrinthe
	 * @throws MazeReadingException Si toutes les lignes n'ont pas la même taille ou qu'un caractère est inconnu.
	 */
	public final void loadFromFile(String filename) throws  MazeReadingException {
		BufferedReader in = null;
		String line;
		
		try {
			in = new BufferedReader(new FileReader(filename));
			int i = 0;
			boolean firstLine = true;
			
			while ((line = in.readLine()) != null)
			{
				int length = line.length();
				if(firstLine)
					this.sizeX = length;
				else {
					if(length != this.sizeX)
						throw new MazeReadingException(filename, i+1, "Incorrect number of columns");
				}
				for(int j = 0; j < this.sizeX; j++) {
					MBox box = null;
					switch (line.charAt(j)) {
					case 'A' :
						box = new ABox(j, i);
						this.vertices.add(box);
						break;
					case 'E' :
						box = new EBox(j, i);
						this.vertices.add(box);
						break;
					case 'W' :
						box = new WBox(j, i);
						this.vertices.add(box);
						break;
					case 'D' :
						box = new DBox(j, i);
						this.vertices.add(box);
						break;
					default :
						throw new MazeReadingException(filename, i, "Unknow letter box");
					}
				}
				i++;
				firstLine = false;
			}
			this.sizeY = i;
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
	
	/** Enregistre le labyrinthe dans un fichier
	 * @param filename Nom du fichier dans lequel sauvegarder
	 */
	public final void saveToTextFile(String filename) {
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(filename);
			
			int n = 1;
			for(VertexInterface v : this.vertices) {
				writer.print(v.getLabel());
				System.out.print(v.getLabel());
				if(n++ % sizeX == 0) {
					writer.print('\n');
					System.out.print('\n');
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error : " + e);
		}
		finally {
			writer.close();
		}
		
		
	}
	
	public ArrayList<VertexInterface> getNeighbors(VertexInterface v) {
		int i = v.getX(), j = v.getY();
		ArrayList<VertexInterface> n = new ArrayList<>();
		
		if(i > 0 && this.vertices.get(i-1).getLabel() != "W") 
			n.add(this.vertices.get(i-1));
		if(i < this.sizeX - 1 && this.vertices.get(i+1).getLabel() != "W") 
			n.add(this.vertices.get(i-1));
		if(j > 0 && this.vertices.get(i-this.sizeX).getLabel() != "W") 
			n.add(this.vertices.get(i-1));
		if(i < this.sizeY - 1 && this.vertices.get(i+this.sizeX).getLabel() != "W") 
			n.add(this.vertices.get(i-1));
		return n;
	}
	
	public int getWeight(VertexInterface a,VertexInterface b) {
		return 1;
	}
	
	public ArrayList<VertexInterface> getVertices() {
		return this.vertices;
	}
	
	int sizeX, sizeY;
	private ArrayList<VertexInterface> vertices;
}

