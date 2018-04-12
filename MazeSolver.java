/**

 */

import java.util.*;

public class MazeSolver {

    private Maze maze;

    private ArrayList <Maze> snapshots;

    public MazeSolver (Maze m) {
	maze = new Maze (m);
    }

    public boolean canSolve(){
	if (maze.explorerIsOnA() == Maze.TREASURE) return true;
	if (maze.explorerIsOnA() == Maze.WALL) {
	    if (snapshots.size() > 0) {
		maze = snapshots.get(snapshots.size() - 1);
		snapshots.remove(snapshots.size() - 1);   
 	    }
	    return false;
	}
	snapshots.add(new Maze (maze) );
	
	    

	}
	
	
	      
	
    }
	    
 
    }

