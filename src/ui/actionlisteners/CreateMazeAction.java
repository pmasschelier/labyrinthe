package ui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.MazeController;
import maze.Maze;

public class CreateMazeAction implements ActionListener {
	
	MazeController mazectrl;
	
	public CreateMazeAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		JOptionPane jop1 = new JOptionPane();
		
		int height = 0;
		int width = 0;
		
		while (height <= 0 || height > 40) {
			String heightS = JOptionPane.showInputDialog(null, "Hauteur de votre labyrinthe ? (40 Max)", "Hauteur", JOptionPane.QUESTION_MESSAGE);
			height = Integer.parseInt(heightS);
		}
		while (width<=0 || height >40) {
			String widthS = JOptionPane.showInputDialog(null, "Largeur de votre labyrinthe ? (40 Max)", "Largeur", JOptionPane.QUESTION_MESSAGE);
			width = Integer.parseInt(widthS);
		}
		
		mazectrl.newVoidMaze(width, height);
		
	}
}
