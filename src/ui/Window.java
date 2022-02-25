package ui;

import javax.swing.*;

import controller.MazeController;

import java.awt.* ;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.HashMap;


final public class Window extends JFrame implements WindowListener {
	
	private static final long serialVersionUID = -4219666736288466382L;
	
	private final DrawingPanel drawingPanel;
	private final MazeController mazectrl;
	
	public static final HashMap<String, Icon> icons = new HashMap<>();
	
	static {
		String dir = "resources/icons/";
		icons.put("new", new ImageIcon(dir + "new.png"));
		icons.put("open", new ImageIcon(dir + "open.png"));
		icons.put("save", new ImageIcon(dir + "save.png"));
		icons.put("close", new ImageIcon(dir + "close.png"));
		icons.put("random", new ImageIcon(dir + "random.png"));
		icons.put("apply", new ImageIcon(dir + "apply.png"));
		icons.put("clear", new ImageIcon(dir + "clear.png"));
	}
	
	public Window(MazeController mazectrl)
	{
		super("Labyrinthe");
		
		this.mazectrl = mazectrl;
		
		
		setJMenuBar(new MenuBar(this, mazectrl)) ;
		//setLayout(new BorderLayout());
		
		add(new ToolBar(mazectrl, this), BorderLayout.NORTH);
		
		add(drawingPanel = new DrawingPanel(), BorderLayout.CENTER);
		mazectrl.setDrawingPanel(drawingPanel);
		
		add(new SidePanel(mazectrl), BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (mazectrl.checkSaved())
			System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
				
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
