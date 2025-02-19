package controllers;

import java.util.*;
import models.Cell;
import models.Maze;

public class RecursiveController implements MazeSolver {
    private List<Cell> visitedNodes = new ArrayList<>();

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
        visitedNodes.clear();

        if (grid == null || grid.length == 0) {
            return path;
        }

        if (findPath(maze, grid, start.row, start.col, end, path, visitadas)) {
            Collections.reverse(path);
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(Maze maze, boolean[][] grid, int row, int col, Cell end, List<Cell> path, Set<Cell> visitadas) {
        Cell cell = new Cell(row, col);

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        if (visitadas.contains(cell)) {
            return false;
        }

        visitadas.add(cell);
        visitedNodes.add(cell);
        maze.updateMaze(cell, path.isEmpty() ? null : path.get(path.size() - 1), end);

        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }

        if (findPath(maze, grid, row + 1, col, end, path, visitadas) || 
            findPath(maze, grid, row, col + 1, end, path, visitadas) || 
            findPath(maze, grid, row - 1, col, end, path, visitadas) || 
            findPath(maze, grid, row, col - 1, end, path, visitadas)) {
            path.add(cell); 
            return true;
        }

        visitadas.remove(cell);
        return false;
    }

    public List<Cell> getVisitedNodes() {
        return visitedNodes;
    }
}
