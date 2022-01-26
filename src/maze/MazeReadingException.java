package maze;

/**
 * Class fille de Exception
 * Représente une erreur de format du fichier labyrinthe
 */
public class MazeReadingException extends Exception {
	public MazeReadingException(String filename, int line, String error) {
		super(error + " (" + filename + " : " + line);
	}
}
