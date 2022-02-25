package ui;

import javax.swing.*;

import controller.MazeController;
import ui.actionlisteners.SaveAction;

import java.awt.* ;
import java.awt.event.ActionEvent;
import java.io.File;


final public class Window extends JFrame {
	
	private final MenuBar menuBar;
	private final DrawingPanel drawingPanel;
	
	public Window(MazeController mazectrl)
	{
		super("Labyrinthe");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(menuBar = new MenuBar(this, mazectrl)) ;
		setLayout(new BorderLayout());
		
		add(drawingPanel = new DrawingPanel(), BorderLayout.CENTER);
		mazectrl.setDrawingPanel(drawingPanel);
		
		add(new SidePanel(mazectrl), BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}
	
	public void showError(String title, String msg) {
		JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public String getFilename(String title) {
		try{
			JFileChooser chooser = new JFileChooser();
			
			chooser.setCurrentDirectory(new  File("." + File.separator)); // Dossier Courant
			int reponse = chooser.showDialog(this, title); //Affichage et récupération de la réponse de l'utilisateur
			
			if  (reponse == JFileChooser.APPROVE_OPTION){ // Si l'utilisateur clique sur OK
				String  filename = chooser.getSelectedFile().toString();
				return filename;
			}
		}
		catch(HeadlessException he){
			he.printStackTrace();
		}
		
		return null;
	}
	
}
