package ui.tilechooser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import main.MazeController;
import ui.DrawingPanel;
import ui.Window;

public class TileChooserDialog extends JDialog {
	
	private TileColorPanel colorDisplay;
	private JButton cancelButton, applyButton;
	private JPanel buttonPanel;
	
	private static final long serialVersionUID = 8144284915221919277L;

	public TileChooserDialog(MazeController mazectrl, Window window) {
		super(window, "Choisissez la couleur des cases", true);
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(colorDisplay = new TileColorPanel(mazectrl));
		colorDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		add(buttonPanel = new JPanel());
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		buttonPanel.add(cancelButton = new JButton("Annuler"));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		buttonPanel.add(applyButton = new JButton("Appliquer et Fermer"));
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel panel = mazectrl.getWindow().getDrawingPanel();
				HashMap<String, Color> tilesColor = panel.getDPMgr().getTilesColors();
				colorDisplay.setColorMap(tilesColor);
				panel.repaint();
				dispose();
			}
		});
		applyButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		pack();
		setVisible(true);
	}
	
}
