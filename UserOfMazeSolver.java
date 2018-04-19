import java.util.*;

public class UserOfMazeSolver {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("USAGE: java UserOfMazeSolver PATH RANK FILE\n");
            System.out.println("    PATH (filepath):");
            System.out.println("        The path to the maze text file\n");
            System.out.println("    RANK (int):");
            System.out.println("        The rank the explorer starts on\n");
            System.out.println("    FILE (int):");
            System.out.println("        The file the explorer starts on\n");
            return;
        }
      	Maze maze = null;
        String sourceFilename = args[0];
        int rank = Integer.parseInt(args[1]);
        int file = Integer.parseInt(args[2]);
        while (maze == null) {
            try {
            	maze = new Maze(sourceFilename, rank, file);
          	} catch (java.io.FileNotFoundException e) {
                Scanner consoleReader = new Scanner(System.in);
            	while (consoleReader.hasNext()) {
                    sourceFilename = consoleReader.next();
                    break;
                }
          	}
        }
        MazeSolver solver;
        solver = new MazeSolver(maze);
        System.out.println("Can Solve: " + solver.canSolve());
        solver = new MazeSolver(maze);
        System.out.println("Solutions: " + solver.solve());
    }
}
