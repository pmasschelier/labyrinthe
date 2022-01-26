package maze;

/**
 * Class fille de MBox
 * Représente un mur du labyrinthe
 */
public class WBox extends MBox {
	public WBox(int x, int y) {
		super(x, y);
	}
	
	public String getLabel() {
		return "W";
	}
}

