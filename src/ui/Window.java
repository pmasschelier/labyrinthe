package ui;

import javax.swing.*;

import main.MazeController;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.HashMap;

/**
 * <b>Classe représentant la fenêtre principale</b>
 * <p>
 * La fenêtre est une JFrame qui implémente son propre WindowListener.
 * </p>
 * <p>
 * La classe fournit une HashMap statique fournissant les icones pour les
 * éléments de la fenêtre.
 * </p>
 * <p>
 * La fenêtre contient une MenuBar, une ToolBar, un DrawingPanel et un SidePanel
 * </p>
 * 
 * @see MenuBar
 * @see ToolBar
 * @see DrawingPanel
 * @see BoxChooserPanel
 * @see MazeController
 * 
 * @author masschelier@telecom-paris.fr
 *
 */
final public class Window extends JFrame implements WindowListener {

    private static final long serialVersionUID = -4219666736288466382L;

    private final DrawingPanel drawingPanel;
    private final MazeController mazectrl;

    public static final HashMap<String, Icon> icons = new HashMap<>();

    static {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        String dir = "resources/icons/";
        icons.put("new", new ImageIcon(loader.getResource(dir + "new.png")));
        icons.put("open", new ImageIcon(loader.getResource(dir + "open.png")));
        icons.put("save", new ImageIcon(loader.getResource(dir + "save.png")));
        icons.put("close", new ImageIcon(loader.getResource(dir + "close.png")));
        icons.put("random", new ImageIcon(loader.getResource(dir + "random.png")));
        icons.put("apply", new ImageIcon(loader.getResource(dir + "apply.png")));
        icons.put("clear", new ImageIcon(loader.getResource(dir + "clear.png")));
    }

    public Window(MazeController mazectrl) {
        super("Labyrinthe");

        this.mazectrl = mazectrl;

        setJMenuBar(new MenuBar(mazectrl, this));
        // setLayout(new BorderLayout()); // BorderLayout est déjà le layout par défaut
        // d'une fenêtre swing

        add(new ToolBar(mazectrl), BorderLayout.NORTH);

        add(drawingPanel = new DrawingPanel(mazectrl), BorderLayout.CENTER);

        add(new BoxChooserPanel(mazectrl), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);

        pack();
        setVisible(true);
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    /**
     * Affiche un fenêtre d'erreur
     * 
     * @param title Titre de la fenêtre d'erreur
     * @param msg   Message à afficher
     */
    public void showError(String title, String msg) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @param title
     * @param msg
     * @return
     */
    public int getValue(String title, String msg) {
        String widthS = JOptionPane.showInputDialog(this, msg, title, JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(widthS);
    }

    /**
     * Affiche une fenêtre permettant de choisir un fichier sur le disque
     * 
     * @param title Titre de la fenêtre
     * @return Chemin absolu du fichier séléctionné ou null si aucun fichier n'a été
     *         séléctionné
     */
    public String getFilename(String title) {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setCurrentDirectory(new File("." + File.separator)); // Dossier Courant
            int reponse = chooser.showDialog(this, title); // Affichage et récupération de la réponse de l'utilisateur

            if (reponse == JFileChooser.APPROVE_OPTION) { // Si l'utilisateur clique sur OK
                String filename = chooser.getSelectedFile().toString();
                return filename;
            }
        } catch (HeadlessException he) {
            he.printStackTrace();
        }

        return null;
    }

    public Color getColor(Color initial) {
        return JColorChooser.showDialog(this, "Choisissez une couleur", initial);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Vérifie que le labyrinthe a été enregistré avant de fermer l'application.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if (mazectrl.checkSaved())
            dispose();
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
