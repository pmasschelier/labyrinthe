package ui.tilechooser;

import javax.swing.JPanel;

import main.MazeController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <b>Classe représentant les panneaux cliquables qui affichent les couleurs des cases</b>
 * <p>Au clic sur le panneau, il ouvre un JColorChooser qui permet de choisir la nouvelle
 * couleur pour la case</p>
 * 
 * @see TileColorPanel
 * @see TileChooserDialog
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class TileColorDisplay extends JPanel implements MouseListener {

	private static final long serialVersionUID = -1254268659523708085L;
	
	private final MazeController mazectrl;
	private Color color;
	private final String label;

	/**
	 * Constructeur de TileColorDisplay, crée une case de la couleur correspondant au label passé
	 * @param mazectrl controlleur de l'application, utilisé pour récupérer les couleurs et la fenêtre
	 * @param label type de la case à afficher
	 */
	public TileColorDisplay(MazeController mazectrl, String label) {
		this.mazectrl = mazectrl;
		this.label = label;
		
		color = mazectrl.getWindow().getDrawingPanel().getDPMgr().getTilesColors().get(label);
		setBackground(color);
		setPreferredSize(new Dimension(70, 70));
		
		addMouseListener(this);
		
	}
	
	/**
	 * Renvoie la couleur de la case
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Renvoie le label de la case
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Ouvre une fenetre permettant de choisir la couleur de la case
	 */
	public void mouseClicked(MouseEvent arg0) {
		Color selectedColor = mazectrl.getWindow().getColor(color);
		if(selectedColor != null ) {
			color = selectedColor;
			setBackground(color);
		}
		repaint();
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
