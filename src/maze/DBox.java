package maze;

/**
 * <b>Représente une case de départ du labyrinthe</b>
 * Classe fille de MBox
 * 
 * @author masschelier@telecom-paris.fr
 */
public final class DBox extends MBox {
	public DBox(int x, int y) {
		super("D", true, x, y);
	}
}
