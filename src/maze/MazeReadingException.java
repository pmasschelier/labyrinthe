package maze;

public class MazeReadingException extends Exception {
	public MazeReadingException(String filename, int line, String error) {
		super(error + " (" + filename + " : " + line);
	}
}
