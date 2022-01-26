package maze;

/**
 * Class fille de MBox
 * Représente une case de départ du labyrinthe
 */
public class DBox extends MBox {
	public DBox(int x, int y) {
		super(x, y);
	}
	
	public String getLabel() {
		return "D";
	}
}
