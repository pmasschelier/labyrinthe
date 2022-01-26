package maze;

/**
 * Class fille de MBox
 * Représente une case d'arrivée du labyrinthe
 */
public class ABox extends MBox {
	public ABox(int x, int y) {
		super(x, y);
	}
	
	public String getLabel() {
		return "A";
	}
}
