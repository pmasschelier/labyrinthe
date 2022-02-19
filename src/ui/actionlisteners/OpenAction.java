package ui.actionlisteners;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import controller.MazeController;
import maze.Maze;
import maze.MazeReadingException;

public class OpenAction implements ActionListener {
	
	MazeController mazectrl;
	
	public OpenAction(MazeController mazectrl) {
		this.mazectrl = mazectrl;
	}

	public void actionPerformed(ActionEvent e){
		try {
			JFileChooser chooser = new JFileChooser();
			
			chooser.setCurrentDirectory(new  File("." + File.separator)); // Dossier Courant
			int reponse = chooser.showDialog(chooser,"Create"); //Affichage et récupération de la réponse de l'utilisateur
			
			if  (reponse == JFileChooser.APPROVE_OPTION) { // Si l'utilisateur clique sur OK
				String  filename= chooser.getSelectedFile().toString(); // Récupération du chemin du fichier
				mazectrl.openMaze(filename);
			}
		}
		catch(HeadlessException he){
			he.printStackTrace();
		}
	}
}
