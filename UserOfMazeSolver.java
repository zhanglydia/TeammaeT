public class UserOfMazeSolver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        TestStartOnTreasure();
	TestOneStep();
        TestNoTreasure();
        TestIntersectionNoTreasure();
        TestIntersectionTreasureNorth();
        TestCorridorTreasureWest();
        TestAllSteps();
        TestComplexMaze();
    }

    public static void TestStartOnTreasure() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/4cell_treasureWest.txt", 0, 0);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting 0");

    }

    public static void TestOneStep() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/4cell_treasureWest.txt", 0, 1);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting 1");

    }

    public static void TestNoTreasure() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/oneStepNoTreasure.txt", 0, 0);
        boolean expected = false;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting -2");
    }

    public static void TestIntersectionNoTreasure() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/intersection_noTreasure.txt", 1, 1);
        boolean expected = false;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting -2");
    }

    public static void TestIntersectionTreasureNorth() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/intersection_treasureNorth.txt", 1, 1);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting 1");
    }

    public static void TestCorridorTreasureWest() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/4cell_treasureWest.txt", 0, 2);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
    }

    public static void TestAllSteps() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/steppingStonesEverywhere.txt", 0, 0);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
    }

    public static void TestComplexMaze() throws java.io.FileNotFoundException {
        Maze m = new Maze("mazes/16x32.txt", 7, 15);
        boolean expected = true;
        MazeSolver solver = new MazeSolver(m);
        if (solver.canSolve() == expected) {
            System.out.println("Test passing");
        } else {
            System.out.println("Test failed!");
        }
	System.out.println(solver.numSteps());
	System.out.println("expecting 53?");
    }
}
