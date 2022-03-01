package maze;

/**
 * <b>Représente une case vide du labyrinthe</b>
 * Classe fille de MBox
 * 
 * @author masschelier@telecom-paris.fr
 */
public final class EBox extends MBox {
	public EBox(int x, int y) {
		super("E", true, x, y);
	}
}
