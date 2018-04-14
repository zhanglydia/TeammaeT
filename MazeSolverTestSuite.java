import java.util.*;

public class MazeSolverTestSuite {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Test_canTest t = new Test_canTest();
        t.newTest("Start On Treasure", "mazes/4cell_treasureWest.txt", 0, 0, true);
        t.newTest("No Treasure", "mazes/oneStepNoTreasure.txt", 0, 0, false);
        t.newTest("Intersection No Treasure", "mazes/intersection_noTreasure.txt", 1, 1, false);
        t.newTest("Intersection Treasure North", "mazes/intersection_treasureNorth.txt", 1, 1, true);
        t.newTest("Corridor Treasure West", "mazes/4cell_treasureWest.txt", 0, 2, true);
        t.newTest("Corridor Treasure East", "mazes/straightToTreasure.txt", 0, 0, true);
        t.newTest("Path with Turn", "mazes/pathWithTurn.txt", 2, 0, true);
        t.newTest("Path with Choice", "mazes/pathWithChoice.txt", 3, 0, true);
        t.newTest("Looping Danger", "mazes/loopingDanger.txt", 0, 0, true);
        t.newTest("Simpler Looping Danger", "mazes/simplerLoopingDanger.txt", 0, 0, true);
        t.newTest("Trouble Turning", "mazes/troubleTurning.txt", 0, 0, false);
        t.newTest("Trouble Hitting Walls", "mazes/troubleNavigating.txt", 2, 2, false);
        t.newTest("Trouble Hitting Edge", "mazes/troubleNavigating.txt", 0, 0, false);
        t.newTest("Trouble Finding Treasure", "mazes/troubleFindingTreasure.txt", 2, 2, true);
        t.newTest("All Steps", "mazes/steppingStonesEverywhere.txt", 0, 0, true);
        t.newTest("Complex Maze", "mazes/16x32.txt", 7, 15, true);
        t.newTest("Hello Kitty", "mazes/helloKitty.txt", 6, 3, true);
        t.runTests();
    }
}

class Test_canTest {
    private ArrayList<ArrayList<Object>> tests = new ArrayList<ArrayList<Object>>();
    private ArrayList<ArrayList<Object>> failingTests = new ArrayList<ArrayList<Object>>();

    public void newTest(String name, String sourceFilename, int explorerRank, int explorerFile, boolean expected) {
        ArrayList<Object> test = new ArrayList<Object>();
        test.add(name);
        test.add(sourceFilename);
        test.add(explorerRank);
        test.add(explorerFile);
        test.add(expected);
        tests.add(test);
    }

    public void runTests() throws java.io.FileNotFoundException {
        for (int i = 0; i < tests.size(); i++) {
            ArrayList<Object> test = tests.get(i);

            String name = (String)test.get(0);
            String sourceFilename = (String)test.get(1);
            int explorerRank = (int)test.get(2);
            int explorerFile = (int)test.get(3);
            boolean expected = (boolean)test.get(4);

            Maze m = new Maze(sourceFilename, explorerRank, explorerFile);
            MazeSolver solver = new MazeSolver(m);
            boolean got = solver.canSolve();
            if (got != expected) {
                test.add(got);
                failingTests.add(test);
            }
        }

        if (failingTests.size() == 0) {
            System.out.println("All tests passing.");
            return;
        }

        String message = "Failing Tests:\n";
        for (int i = 0; i < failingTests.size(); i++) {
            ArrayList<Object> test = failingTests.get(i);

            String name = (String)test.get(0);
            String sourceFilename = (String)test.get(1);
            int explorerRank = (int)test.get(2);
            int explorerFile = (int)test.get(3);
            boolean expected = (boolean)test.get(4);
            boolean got = (boolean)test.get(5);

            message += "    Test: " + name + "\n";
            message += "        Maze: " + sourceFilename + "\n";
            message += "        Starting: (" + explorerRank + ", " + explorerFile + ")\n";
            message += "        Expected " + expected + ", but got " + got + "\n";
        }

        System.out.println(message);
    }
}
