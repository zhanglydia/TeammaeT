import java.util.*;

public class MazeSolver {
    private Maze maze;

    private final static int[] DIRECTIONS = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};

    public MazeSolver(Maze m) {
        maze = new Maze(m);
    }

    public ArrayList<ArrayList<Integer>> solve() {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

        if (maze.explorerIsOnA() == Maze.TREASURE) {
            paths.add(new ArrayList<Integer>());
            return paths;
        }

        if (maze.explorerIsOnA() == Maze.WALL) {
            return new ArrayList<ArrayList<Integer>>();
        }

        Maze snapshot = new Maze(maze);
        for (int dir : DIRECTIONS) {
            maze.dropA(Maze.WALL);
            maze.go(dir);
            ArrayList<ArrayList<Integer>> solutions = solve();
            for (int i = 0; i < solutions.size(); i++) {
                ArrayList<Integer> path = solutions.get(i);
                path.add(0, dir);
                paths.add(path);
            }
            maze = new Maze(snapshot);
        }
        return paths;
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
