package ui;

import javax.swing.*;

import controller.MazeController;

import java.awt.* ;


public class Window extends JFrame {
	
	MenuBar menuBar;
	DrawingPanel drawingPanel;
	
	public Window(MazeController mazectrl)
	{
		super("Labyrinthe");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(menuBar = new MenuBar(this, mazectrl)) ;
		setLayout(new BorderLayout());
		
		add(drawingPanel = new DrawingPanel(), BorderLayout.CENTER);
		mazectrl.setDrawingPanel(drawingPanel);
		
		pack();
		setVisible(true);
	}
	
	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}
	
}
