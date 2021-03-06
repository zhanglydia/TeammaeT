# TeammaeT

## Personnel

Daniel Keriazis and Lydia Zhang

## Statement of Problem

Return the boolean value of the statement "the maze is navigable, having a legal travel path from current position to existing treasure".

## Recursive Abstraction

When asked to return the boolean value of the statement "the maze is navigable, having a legal travel path from current position to existing treasure",  
the recursive abstraction can return the value of said statement with an explorer in a new position.

## Base Case

The current position is a treasure or a wall.

## English or Pseudocode Description of Algorithm

```
Find all solutions to a maze:
    Create a set of paths
    If current position contains treasure:
        Append an empty array to set
        Return set
    If current position contains a wall:
        Return the empty set
    Create new snapshot of a copy of the current state
    For each cardinal direction:
        Drop a wall
        Move the explorer in that direction
        Get solution of new maze
        For every path in solutions:
            Insert direction as item 0 in path
            Add path to set
        Set the maze to a copy of the snapshot
    Return set
```
```
Determine whether a maze can be solved:
    If current position contains treasure:
        Return true
    If current position contains a wall:
        Return false
    Create new snapshot of a copy of the current state
    For each cardinal direction:
        Drop a wall
        Move the explorer in that direction
        If the new maze can be solved:
            Return true
        Set the maze to a copy of the snapshot
    Return false
```

## Classes with Fields and Methods

### MazeSolver

- #### Fields

  ```java
  private Maze maze;
  private static int[] directions; // used in for-each loop
                                   //holds cardinal directions going counter-clockwise

  ```
- #### Methods

  ```java
  public MazeSolver(Maze m)
  public  boolean canSolve()

  ```

### Maze

- #### Fields

  ```java

  ```
- #### Methods

- `Maze(`*file name for maze*`, `*explorer position*`)`
   constructor: read a maze from a file and position an explorer in it.

- `go(`*direction*`)`: move the explorer one step

- `explorerIsOnA()` returns the maze element in
the cell that the explorer currently occupies.

- `dropA(`*maze element*`)`:  Modify the maze to have a *maze element* in
the cell that the explorer currently occupies.


## Version _n_ Wish List

### v0
- Determine whether a maze can be solved
- Implement test suite
- Implement user class

### v1
- Find all solutions to a maze

## Known Bugs

```
All tests passing.
```

No bugs currently known.  
If you find one, you can create a GitHub issue and it will be appended here.
