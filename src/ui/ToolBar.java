package ui;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import controller.MazeController;
import ui.actionlisteners.CloseAction;
import ui.actionlisteners.CreateMazeAction;
import ui.actionlisteners.CreateRandomMazeAction;
import ui.actionlisteners.EraseAction;
import ui.actionlisteners.OpenAction;
import ui.actionlisteners.QuitAction;
import ui.actionlisteners.SaveAction;
import ui.actionlisteners.SaveAsAction;
import ui.actionlisteners.SolveAction;

final public class ToolBar extends JToolBar {

	private static final long serialVersionUID = -350011054358769608L;
	
	JButton newButton, openButton, saveButton, randomButton, clearButton, solveButton;

	public ToolBar(MazeController mazectrl, Window app) {
		super();

		newButton = new JButton(Window.icons.get("new"));
		newButton.addActionListener(new CreateMazeAction(mazectrl));
		add(newButton);
		
		openButton = new JButton(Window.icons.get("open"));
		openButton.addActionListener(new OpenAction(mazectrl, app));
		add(openButton);
		
		saveButton = new JButton(Window.icons.get("save"));
		saveButton.addActionListener(new SaveAction(mazectrl, app));
		add(saveButton);
		
		randomButton = new JButton(Window.icons.get("random"));
		randomButton.addActionListener(new CreateRandomMazeAction(mazectrl));
		add(randomButton);
		
		clearButton = new JButton(Window.icons.get("clear"));
		clearButton.addActionListener(new EraseAction(mazectrl));
		add(clearButton);
		
		solveButton = new JButton(Window.icons.get("apply"));
		solveButton.addActionListener(new SolveAction(mazectrl));
		add(solveButton);
	}
}
