package controllers;

import java.util.List;

import models.Cell;
import models.Maze;

public interface Mazesolver {
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end);
}
