public class MazeSolver {
    private Maze maze;

    private static int[] directions = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};

    public MazeSolver(Maze m) {
        maze = new Maze(m);
    }

    public  boolean canSolve() {

        if (maze.explorerIsOnA() == Maze.TREASURE) {
            return true;
        }

        if (maze.explorerIsOnA() == Maze.WALL) {
            return false;
        }

        Maze snapshot = new Maze(maze);
        for (int dir : directions) {
            maze.dropA(Maze.WALL);
            maze.go(dir);
            if (canSolve()) {
                return true;
            }
            maze = new Maze(snapshot);
        }
        return false;
    }

    public int numSteps(){
	if (maze.explorerIsOnA() == Maze.TREASURE) {
	    return 0;
        }

        if (maze.explorerIsOnA() == Maze.WALL) {
	    return -1;
        }


        Maze snapshot = new Maze(maze);
        for (int dir : directions) {
            maze.dropA(Maze.WALL);
            maze.go(dir);
	    int stepCount = numSteps();
	    if (stepCount  >= 0){
	       
		return 1 + stepCount;
	    }
	    maze = new Maze(snapshot);
        } 
        return -1;
    }


}
