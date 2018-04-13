public class MazeSolver {
    private Maze maze;

    private final static int[] DIRECTIONS = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};

    public MazeSolver(Maze m) {
        maze = new Maze(m);
    }

    public boolean canSolve() {
        if (maze.explorerIsOnA() == Maze.TREASURE) {
            return true;
        }

        if (maze.explorerIsOnA() == Maze.WALL) {
            return false;
        }

        Maze snapshot = new Maze(maze);
        for (int dir : DIRECTIONS) {
            maze.dropA(Maze.WALL);
            maze.go(dir);
            if (canSolve()) {
                return true;
            }
            maze = new Maze(snapshot);
        }
        return false;
    }
}
