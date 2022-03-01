package ui;

import javax.swing.*;

import main.MazeController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b> BoxChoserPanel est la classe représentant le panneau de boutons radios qui
 * permet de choisir la case de labyrinthe que l'on va poser </b>
 * <p>
 * Les quatre boutons radios contenu dans le panneau sont :
 * <ul>
 * <li>Le bouton "Mur" séléctionné par défaut</li>
 * <li>Le bouton "Vide"</li>
 * <li>Le bouton "Départ"</li>
 * <li>Le bouton "Arrivé"</li>
 * </ul>
 * </p>
 * <p>Dès que la séléction est changé on notifie le controlleur</p>
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class BoxChoserPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -8032292675876438992L;
	
	private final JRadioButton buttonWall, buttonEmpty, buttonDeparture, buttonArrival;
	private final ButtonGroup group;
	private final MazeController mazectrl;
	
	/**
	 * Constructeur de la classe BoxChoserPanel
	 * @param mazectrl Controlleur à notifier lors du changement de séléction
	 */
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
	
	/**
	 * Méthode à implémenter pour l'interface ActionListener
	 * <p>Cette méthode est appellée dès que la séléction de bouton est changée.
	 * Elle appelle la méthode setCurrentBox de MazeController en passant la valeur du bouton qui a été séléctionnée.</p>
	 * @see MazeController#setCurrentBox
	 */
	public void actionPerformed(ActionEvent e) {
		mazectrl.setCurrentBox(group.getSelection().getActionCommand());
	}
}
