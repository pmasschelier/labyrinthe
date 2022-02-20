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
import javax.swing.JOptionPane;

import controller.MazeController;
import maze.Maze;
import maze.MazeReadingException;
import ui.Window;

public class OpenAction implements ActionListener {
	
	MazeController mazectrl;
	Window app;
	
	public OpenAction(MazeController mazectrl, Window app) {
		this.mazectrl = mazectrl;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e){		
		String filename = app.getFilename("Ouvrir");

		if(filename != null && mazectrl.checkSaved())
				mazectrl.openMaze(filename);
			
	}
}
