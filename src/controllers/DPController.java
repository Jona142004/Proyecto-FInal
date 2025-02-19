package controllers;

import java.util.*;
import models.Cell;
import models.Maze;

public class DPController implements MazeSolver {
    private Map<Cell, Boolean> memoria = new HashMap<>();
    private List<Cell> visitedNodes = new ArrayList<>();

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
        visitedNodes.clear();

        if (grid == null || grid.length == 0) {
            return path;
        }

        if (findPath(grid, start.row, start.col, end, path, visitadas)) {
            Collections.reverse(path);
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path, Set<Cell> visitadas) {
        Cell cell = new Cell(row, col);

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        if (visitadas.contains(cell)) {
            return false;
        }

        if (memoria.containsKey(cell)) {
            return memoria.get(cell);
        }

        visitadas.add(cell);
        visitedNodes.add(cell);

        if (row == end.row && col == end.col) {
            path.add(cell);
            memoria.put(cell, true);
            return true;
        }

        if (findPath(grid, row + 1, col, end, path, visitadas) || 
            findPath(grid, row, col + 1, end, path, visitadas) || 
            findPath(grid, row - 1, col, end, path, visitadas) || 
            findPath(grid, row, col - 1, end, path, visitadas)) {
            path.add(cell); 
            memoria.put(cell, true);
            return true;
        }

        visitadas.remove(cell);
        memoria.put(cell, false);
        return false;
    }

    public List<Cell> getVisitedNodes() {
        return visitedNodes;
    }
}
