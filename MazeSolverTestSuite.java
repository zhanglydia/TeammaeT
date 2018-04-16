import java.util.*;

public class MazeSolverTestSuite {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Test.newTest_canSolve("Start On Treasure", "mazes/4cell_treasureWest.txt", 0, 0, true);
        Test.newTest_canSolve("No Treasure", "mazes/oneStepNoTreasure.txt", 0, 0, false);
        Test.newTest_canSolve("Intersection No Treasure", "mazes/intersection_noTreasure.txt", 1, 1, false);
        Test.newTest_canSolve("Intersection Treasure North", "mazes/intersection_treasureNorth.txt", 1, 1, true);
        Test.newTest_canSolve("Corridor Treasure West", "mazes/4cell_treasureWest.txt", 0, 2, true);
        Test.newTest_canSolve("Corridor Treasure East", "mazes/straightToTreasure.txt", 0, 0, true);
        Test.newTest_canSolve("Path with Turn", "mazes/pathWithTurn.txt", 2, 0, true);
        Test.newTest_canSolve("Path with Choice", "mazes/pathWithChoice.txt", 3, 0, true);
        Test.newTest_canSolve("Looping Danger", "mazes/loopingDanger.txt", 0, 0, false);
        Test.newTest_canSolve("Simpler Looping Danger", "mazes/simplerLoopingDanger.txt", 0, 0, true);
        Test.newTest_canSolve("Trouble Turning", "mazes/troubleTurning.txt", 0, 0, false);
        Test.newTest_canSolve("Trouble Hitting Walls", "mazes/troubleNavigating.txt", 2, 2, false);
        Test.newTest_canSolve("Trouble Hitting Edge", "mazes/troubleNavigating.txt", 0, 0, false);
        Test.newTest_canSolve("Trouble Finding Treasure", "mazes/troubleFindingTreasure.txt", 2, 2, true);
        Test.newTest_canSolve("All Steps", "mazes/steppingStonesEverywhere.txt", 0, 0, true);
        Test.newTest_canSolve("Complex Maze", "mazes/16x32.txt", 7, 15, true);
        Test.newTest_canSolve("Hello Kitty", "mazes/helloKitty.txt", 6, 3, true);

        Test.runTests();
    }
}

class Test {
    private static ArrayList<Tester> tests = new ArrayList<Tester>();
    protected static ArrayList<Tester> failingTests = new ArrayList<Tester>();

    public static void newTest_canSolve(String name, String sourceFilename, int explorerRank, int explorerFile, boolean expected) {
        tests.add(new Test_canSolve(name, sourceFilename, explorerRank, explorerFile, expected));
    }

    public static void runTests() throws java.io.FileNotFoundException {
        for (int i = 0; i < tests.size(); i++) {
            Tester test = tests.get(i);
            test.run();
        }

        if (failingTests.size() == 0) {
            System.out.println("All tests passing.");
            return;
        }

        String message = "Failing Tests:\n";
        for (int i = 0; i < failingTests.size(); i++) {
            Tester test = failingTests.get(i);
            message += test;
        }

        System.out.print(message);
    }
}

interface Tester {
    public void run() throws java.io.FileNotFoundException;
}

class Test_canSolve extends Test implements Tester {
    private String name;
    private String sourceFilename;
    private int explorerRank;
    private int explorerFile;
    private boolean expected;
    private boolean got;

    public Test_canSolve(String name, String sourceFilename, int explorerRank, int explorerFile, boolean expected) {
        this.name = name;
        this.sourceFilename = sourceFilename;
        this.explorerRank = explorerRank;
        this.explorerFile = explorerFile;
        this.expected = expected;
    }

    public String toString() {
        String message = "";
        message += "    Test (canSolve): " + name + "\n";
        message += "        Maze: " + sourceFilename + "\n";
        message += "        Starting: (" + explorerRank + ", " + explorerFile + ")\n";
        message += "        Expected " + expected + ", but got " + got + "\n";
        return message;
    }

    public void run() throws java.io.FileNotFoundException {
        Maze m = new Maze(sourceFilename, explorerRank, explorerFile);
        MazeSolver solver = new MazeSolver(m);
        got = solver.canSolve();
        if (got != expected) {
            failingTests.add(this);
        }
    }
}
