package ui;

import javax.swing.* ;

import java.awt.* ;
import java.util.ArrayList;

import maze.MBox;
import maze.Maze;

final public class DrawingPanel extends JPanel {
	
	private final Dimension size = new Dimension(800, 800);
	private final DrawingPanelManager dpmgr;
	
	public DrawingPanel()
	{
		super();
		setBackground(new Color(170, 170, 170));
		setPreferredSize(size);
		
		dpmgr = new DrawingPanelManager(this);		
	}
	
	public void notifyForUpdate() {
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dpmgr.paintAllTiles(g);
		dpmgr.paintPath(g);
	}
	
	
	public DrawingPanelManager getDPMgr() {
		return dpmgr;
	}
}
