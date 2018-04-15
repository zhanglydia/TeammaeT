public class UserOfMazeSolver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
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
        int rank = Integer.parseInt(args[1]);
        int file = Integer.parseInt(args[2]);
        Maze maze = new Maze(args[0], rank, file);
        MazeSolver solver = new MazeSolver(maze);
        System.out.println("Can Solve: " + solver.canSolve());
    }
}