package ui.tilechooser;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import main.MazeController;

public class TileColorPanel extends JPanel {

	private static final long serialVersionUID = 2007527143610547554L;
	
	private TileColorDisplay wallPanel, emptyPanel, departurePanel, arrivalPanel;
	
	public TileColorPanel(MazeController mazectrl) {
		super();
		
		setLayout(new GridLayout(2, 4, 20, 0));
		
		add(new JLabel("Mur", JLabel.CENTER));
		add(new JLabel("Vide", JLabel.CENTER));
		add(new JLabel("Départ", JLabel.CENTER));
		add(new JLabel("Arrivée", JLabel.CENTER));

		add(wallPanel = new TileColorDisplay(mazectrl, "W"));
		
		add(emptyPanel = new TileColorDisplay(mazectrl, "E"));
		
		add(departurePanel = new TileColorDisplay(mazectrl, "D"));
		
		add(arrivalPanel = new TileColorDisplay(mazectrl, "A"));
	}
	
	public void setColorMap(HashMap<String, Color> colors) {
		colors.put(wallPanel.getLabel(), wallPanel.getColor());
		colors.put(emptyPanel.getLabel(), emptyPanel.getColor());
		colors.put(departurePanel.getLabel(), departurePanel.getColor());
		colors.put(arrivalPanel.getLabel(), arrivalPanel.getColor());
	}
	
}
