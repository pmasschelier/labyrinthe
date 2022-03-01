package ui;

import javax.swing.* ;
import javax.swing.event.MouseInputListener;

import main.MazeController;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <b>DrawingPanel est la classe représentant le panneau dans lequel on va
 * dessiner le labyrinthe </b>
 * <p>Le panneau utilise un objet de la classe DrawingPanelManager pour s'occuper du dessin</p>
 * 
 * @see DrawingPanelManager
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class DrawingPanel extends JPanel implements MouseListener, MouseInputListener {
	
	private static final long serialVersionUID = 3723233019704067890L;
	
	private final Dimension size = new Dimension(800, 800);
	private final DrawingPanelManager dpmgr;
	private final MazeController mazectrl;
	
	/**
	 * Constructeur de DrawingPanel, crée un JPanel avec une taille par défaut
	 * de 800x800 et un couleur de fond rgb(170, 170, 170)
	 */
	public DrawingPanel(MazeController mazectrl)
	{
		super();
		
		this.mazectrl = mazectrl;
		
		setBackground(new Color(170, 170, 170));
		setPreferredSize(size);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		dpmgr = new DrawingPanelManager(this);		
	}
	
	/**
	 * Méthode a appelé quand la zone de dessin doit être mise à jour
	 */
	public void notifyForUpdate() {
		repaint();
	}
	
	/**
	 * Méthode appelée par swing après un appel à repaint
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dpmgr.paintAllTiles(g);
		dpmgr.paintPath(g);
	}
	
	
	/**
	 * @return renvoie le drawing panel manager
	 */
	public DrawingPanelManager getDPMgr() {
		return dpmgr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mazectrl.clickAt(e.getX(), e.getY());
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mazectrl.clickAt(e.getX(), e.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
