# TeammaeT

## Personnel

Daniel Keriazis and Lydia Zhang

## Statement of Problem

Return the boolean value of the statement "the maze is navigable, having a legal travel path from current position to existing treasure"

## Recursive Abstraction

Return the boolean value of the statement "the maze is navigable, having a legal travel path from explorer's next position to existing treasure" given starting moves

## Base Case

The current position is a treasure or there are no legal moves.

## English or Pseudocode Description of Algorithm

    If current position is treasure, return true
    If there are no legal moves, return false
    Iterate through the legal moves, recurse on each move

## Classes with Fields and Methods

### Maze

-   #### Fields
    ```java
    private boolean[][] cells; // Each cell has the boolean value of the
                               // statement "this cell is a path"
    private Explorer explorer;
    ```
-   #### Methods
    ```java
    public boolean cell(int rank, int file);
    public String toString();
    ```

## Version _n_ Wish List

- Tests
  - Null maze
  - No treasure
  - Treasure but no path
  - Basic mazes
