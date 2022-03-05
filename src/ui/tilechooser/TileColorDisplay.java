package ui.tilechooser;

import javax.swing.JPanel;

import main.MazeController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

final public class TileColorDisplay extends JPanel implements MouseListener {

	private static final long serialVersionUID = -1254268659523708085L;
	
	private final MazeController mazectrl;
	private Color color;
	private final String label;

	public TileColorDisplay(MazeController mazectrl, String label) {
		this.mazectrl = mazectrl;
		this.label = label;
		
		color = mazectrl.getWindow().getDrawingPanel().getDPMgr().getTilesColors().get(label);
		setBackground(color);
		setPreferredSize(new Dimension(70, 70));
		
		addMouseListener(this);
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getLabel() {
		return label;
	}

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
