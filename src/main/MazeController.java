package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;

import javax.swing.JOptionPane;

import dijkstra.*;
import maze.*;
import ui.*;

/**
 * <b>Classe représentant le controleur de l'application. C'est elle qui doit être instanciée pour
 * commencer à jouer</b>
 * <p>La classe fait le lien entre le modèle composé du package maze et la vu composée du package ui.
 * Pour cela elle possède en attribut une instance de Window (vue) et une instance de Maze (modèle)</p>
 * <p>La classe est appelée à chaque action de l'utilisateur sur le labyrinthe pour mettre à jour la
 * fenêtre est la structure de donnée</p>
 * 
 * @see Maze
 * @see Window
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class MazeController {
	private Maze maze;
	private Window app;
	private DrawingPanel panel;
	private String filename = null;
	private boolean saved = true;
	private String currentBoxLabel = "W";
	
	/**
	 * Constructeur de MazeController, il instancie une fenêtre.</br>
	 * maze reste null tant qu'il n'a pas été créé ou chargé.
	 */
	public MazeController() {
		app = new Window(this);
		panel = app.getDrawingPanel();
	}
	
	/**
	 * Setter pour currentBoxLabel.
	 * @param label label de la boite à placer au prochain clic sur le DrawingPanel
	 */
	public void setCurrentBox(String label) {
		currentBoxLabel = label;
	}
	
	/**
	 * Demande ses dimensions puis crée un nouveau labyrinthe rempli de cases vides.
	 * @return true ssi le labyrinthe a pu être crée
	 * @see MazeController#newVoidMaze(int, int)
	 */
	public boolean newVoidMaze() {
		int height = 0;
		int width = 0;
		
		try {
			while (height <= 0 || height > 100) {
				String heightS = JOptionPane.showInputDialog(app, "Hauteur de votre labyrinthe ? (100 Max)", "Hauteur", JOptionPane.QUESTION_MESSAGE);
				height = Integer.parseInt(heightS);
			}
			while (width <=0 || height > 100) {
				String widthS = JOptionPane.showInputDialog(app, "Largeur de votre labyrinthe ? (100 Max)", "Largeur", JOptionPane.QUESTION_MESSAGE);
				width = Integer.parseInt(widthS);
			}
			return newVoidMaze(width, height);
		}
		catch (Exception exc) {
			// Rien à faire, simplement on ne crée pas de nouveau labyrinthe
			return false;
		}
	}
	
	/**
	 * Crée un nouveau labyrinthe rempli de cases vides aux dimensions demandée
	 * @param width largeur du labyrinthe
	 * @param height hauteur du labyrinthe
	 * @return true ssi le labyrinthe a pu être créé
	 */
	public boolean newVoidMaze(int width, int height) {
		if(!checkSaved())
			return false;
		
		maze = new Maze(width, height);
		updateMaze();
		saved = false;
		filename = null;
		
		return true;
	}
	
	
	/**
	 * Si un labyrinthe existe déjà la fonction demande à le sauvegarder le rempli de cases aléatoires</br>
	 * Sinon demande ses dimensions et crée un labyrinthe rempli de cases aléatoires
	 * @return true ssi le labyrinthe a pu être créé
	 */
	public boolean newRandomMaze() {
		if(maze == null) {
			if(!newVoidMaze())
				return false;
		}
		else {
			if(!newVoidMaze(maze.getSizeX(), maze.getSizeY()))
				return false;
		}
		
		for(int i = 0; i < maze.getSizeX(); i++) {
			for(int j = 0; j < maze.getSizeY(); j++) {
				if(Math.random() > 0.5)
					maze.setBox(new WBox(i, j));
			}
		}
		saved = false;
		filename = null;
		updateMaze();
		
		return true;
	}
	
	/**
	 * Ouvre un fichier labyrinthe sur le disque.
	 * @param filename Chemin vers le labyrinthe à ouvrir
	 */
	public void openMaze(String filename) {
		try {
			if(maze == null)
				maze = new Maze();
			maze.loadFromFile(filename);
			this.filename = filename;
			updateMaze();
			saved = true;
			
		}
		catch(FileNotFoundException e) {
			app.showError("Fichier non trouvé", e.getMessage());
		}
		catch(IOException e) {
			app.showError("Erreur de lecture", e.getMessage());
		}
		catch(MazeReadingException e) {
			app.showError("Erreur de format", e.getMessage());
		}
	}
	
	/**
	 * Demande le chemin vers lequel sauvegarder si on ne le connait pas déjà,
	 * puis sauvegarde le labyrinthe à cet emplacement.
	 */
	public void saveMaze() {
		if(maze != null) {
			if(hasFilename()) {
				try {
					maze.saveToTextFile(filename);
					saved = true;
				}
				catch(FileNotFoundException e) {
					app.showError("Erreur lors de l'écriture du fichier", e.getMessage());
				}
			}
			else
				filename = saveAsMaze();
		}
	}
	
	/**
	 * Demande l'emplacement auquel enregistrer le labyrinthe avant de l'enregistrer.
	 * @return Chemin absolu de l'emplacement auquel le labyrinthe a été enregistré
	 */
	public String saveAsMaze() {
		String filename = null;
		
		if(maze != null) {
			filename = app.getFilename("Enregistrer Sous");
			
			if(filename != null) {
				try {
					maze.saveToTextFile(filename);
					saved = true;
				}
				catch(FileNotFoundException e) {
					app.showError("Erreur lors de l'écriture du fichier", e.getMessage());
				}
			}
		}
		
		return filename;
	}
	
	/**
	 * Ferme le labyrinthe
	 */
	public void closeMaze() {
		maze = null;
		filename = null;
		saved = true;
		updateMaze();
	}
	
	/**
	 * Renvoie vrai si on connait l'emplacement auquel se fera la prochaine sauvegarde
	 * @return true ssi filename != null
	 */
	public boolean hasFilename() {
		return filename != null;
	}

	/**
	 * Renvoie vrai si le labyrinthe n'a pas besoin d'être enregistré
	 * @return true ssi le labyrinthe n'a pas subit de modification depuis la dernière sauvegarde
	 */
	public boolean isSaved() {
		return saved;
	}
	
	/**
	 * Vérifie que le labyrinthe a bien été enregistré
	 * @return true ssi l'action en cours peut être continuée ie. on a pas appuyé sur Annuler
	 */
	public boolean checkSaved() {
		if(!isSaved()) {
			int answer = JOptionPane.showConfirmDialog(app, "Voulez-vous enregistrer le labyrinthe avant de le fermer ?");
			if (answer == JOptionPane.YES_OPTION){
				 saveMaze();
			}
			return answer != JOptionPane.CANCEL_OPTION;
		}
		return true;
	}
	
	/**
	 * Méthode a appeler dès que le labyrinthe a été mis a jour pour le redessiner
	 */
	public void updateMaze() {
		panel.getDPMgr().setMaze(maze);
		panel.getDPMgr().setPath(null);
		panel.notifyForUpdate();
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur demande à résoudre le labyrinthe.
	 * Des tests sont effectués puis l'algorithme de Dijkstra est appliqué au labyrinthe.
	 * Si celui-ci a une solution on l'affiche sur le DrawingPanel
	 */
	public void solve() {
		if(maze == null) {
			JOptionPane.showMessageDialog(app, "Aucun labyrinthe à résoudre", "Pas de labyrinthe", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(maze.getStart() == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas de départ", "Absence de départ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(maze.getEnd() == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas d'arrivée", "Absence d'arrivée", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		PreviousInterface prev = Dijkstra.dijkstra(maze, maze.getStart());
		
		if(prev.getFather(maze.getEnd()) == null) {
			JOptionPane.showMessageDialog(app, "Le labyrinthe n'a pas de solution", "Labyrinthe insoluble", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ArrayDeque<VertexInterface> path = prev.getShortestPathTo(maze.getEnd());
		
		panel.getDPMgr().setPath(path);
		panel.notifyForUpdate();
	}
	
	/**
	 * Méthode appelée lors d'un clic sur le DrawingPanel pour mettre a jour le labyrinthe
	 * @param x coordonnée x du clic en pixel
	 * @param y coordonnée y du clic en pixel
	 */
	public void clickAt(int x, int y) {
		if(maze == null)
			return;
		
		int xi = x * maze.getSizeX() / panel.getWidth();
		int yi = y * maze.getSizeY() / panel.getHeight();
		
		switch(currentBoxLabel) {
		case "E":
			maze.setBox(new EBox(xi, yi));
			break;
		case "A":
			maze.setBox(new ABox(xi, yi));
			break;
		case "D":
			maze.setBox(new DBox(xi, yi));
			break;
		default:
			maze.setBox(new WBox(xi, yi));
			break;
		}

		panel.getDPMgr().setPath(null);
		panel.notifyForUpdate();
		saved = false;
	}
	
	/**
	 * @return maze
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * @return app
	 */
	public Window getWindow() {
		return app;
	}
}
