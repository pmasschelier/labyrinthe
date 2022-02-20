package tp04;

import controller.MazeController;
import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.Maze;
import maze.MazeReadingException;
import ui.Window;

public class MainTest {

	public static void main(String[] args) {
		Maze maze = new Maze();
		try {
			maze.loadFromFile("data/labyrinthe.txt");
		}
		catch (MazeReadingException e) {
			System.out.println(e);
		}
		PreviousInterface prev = Dijkstra.dijkstra(maze, maze.getStart());
		
		char[][] tab = maze.toChars();
		
		VertexInterface current = maze.getEnd();
		while((current = prev.getFather(current)) != maze.getStart()) {
			tab[current.getY()][current.getX()] = '#';
		}
		
		printChars(tab);
		
		
		MazeController mazectrl = new MazeController();
	}

	static public void printChars(char[][] tab) {
		for(char[] row : tab) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.print('\n');
		}
	}
}
