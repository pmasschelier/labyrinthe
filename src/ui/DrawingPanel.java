package ui;

import javax.swing.* ;

import java.awt.* ;
import java.util.ArrayList;

import maze.MBox;
import maze.Maze;

public class DrawingPanel extends JPanel {
	
	private Dimension size = new Dimension(900, 900);
	private DrawingPanelManager dpmgr;
	
	public DrawingPanel()
	{
		
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
		g.setColor(new Color(170, 170, 170));
		g.fillRect(0, 0, getWidth(), getHeight());
		dpmgr.paintAllTiles(g);
	}
	
	
	public DrawingPanelManager getDPMgr() {
		return dpmgr;
	}
}
