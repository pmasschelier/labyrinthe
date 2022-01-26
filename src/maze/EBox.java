package maze;

/**
 * Class fille de MBox
 * Représente une case vide du labyrinthe
 */
public class EBox extends MBox {
	public EBox(int x, int y) {
		super(x, y);
	}
	
	public String getLabel() {
		return "E";
	}
}
