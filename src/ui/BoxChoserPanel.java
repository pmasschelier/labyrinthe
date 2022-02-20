package ui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MazeController;

public class BoxChoserPanel extends JPanel implements ActionListener {
	
	JRadioButton buttonWall, buttonEmpty, buttonDeparture, buttonArrival;
	ButtonGroup group;
	MazeController mazectrl;
	
	public BoxChoserPanel(MazeController mazectrl) {
		this.mazectrl = mazectrl;
		
		// this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add( buttonWall = new JRadioButton("Mur") );
		buttonWall.setActionCommand("W");
		add( buttonEmpty = new JRadioButton("Vide") );
		buttonEmpty.setActionCommand("E");
		add( buttonDeparture = new JRadioButton("Départ") );
		buttonDeparture.setActionCommand("D");
		add( buttonArrival = new JRadioButton("Arrivée") );
		buttonArrival.setActionCommand("A");

		group = new ButtonGroup();
		group.add(buttonWall);
		group.add(buttonEmpty);
		group.add(buttonDeparture);
		group.add(buttonArrival);
		
		buttonWall.setSelected(getFocusTraversalKeysEnabled());

		buttonWall.addActionListener(this);
		buttonEmpty.addActionListener(this);
		buttonDeparture.addActionListener(this);
		buttonArrival.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		mazectrl.setCurrentBox(group.getSelection().getActionCommand());
	}
}
