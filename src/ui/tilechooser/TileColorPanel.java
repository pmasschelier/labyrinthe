package ui.tilechooser;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import main.MazeController;

/**
 * <b>Classe représentant le panneau affichant les couleurs des tuiles</b>
 * <p>JPanel possédant un layout de type GridLayout qui affiche les noms des cases
 * et leur couleur en-dessous</p>
 * 
 * @see TileColorDisplay
 * 
 * @author masschelier@telecom-paris.fr
 */
final public class TileColorPanel extends JPanel {

	private static final long serialVersionUID = 2007527143610547554L;
	
	private final TileColorDisplay wallPanel, emptyPanel, departurePanel, arrivalPanel, pathPanel;
	
	/**
	 * Constructeur de TileColorPanel
	 * @param mazectrl controlleur de l'application
	 */
	public TileColorPanel(MazeController mazectrl) {
		super();
		
		setLayout(new GridLayout(2, 4, 20, 0));
		
		add(new JLabel("Mur", JLabel.CENTER));
		add(new JLabel("Vide", JLabel.CENTER));
		add(new JLabel("Départ", JLabel.CENTER));
		add(new JLabel("Arrivée", JLabel.CENTER));
		add(new JLabel("Chemin", JLabel.CENTER));

		add(wallPanel = new TileColorDisplay(mazectrl, "W"));
		add(emptyPanel = new TileColorDisplay(mazectrl, "E"));
		add(departurePanel = new TileColorDisplay(mazectrl, "D"));
		add(arrivalPanel = new TileColorDisplay(mazectrl, "A"));
		add(pathPanel = new TileColorDisplay(mazectrl, "."));
	}
	
	/**
	 * Fonction mettant à jour la colorMap en fonction des couleurs
	 * séléctionnées pour les différents labels (W, E, D, A, .)
	 * @param colors HashMap des couleurs à modifier
	 */
	public void setColorMap(HashMap<String, Color> colors) {
		colors.put(wallPanel.getLabel(), wallPanel.getColor());
		colors.put(emptyPanel.getLabel(), emptyPanel.getColor());
		colors.put(departurePanel.getLabel(), departurePanel.getColor());
		colors.put(arrivalPanel.getLabel(), arrivalPanel.getColor());
		colors.put(pathPanel.getLabel(), pathPanel.getColor());
	}
	
}
