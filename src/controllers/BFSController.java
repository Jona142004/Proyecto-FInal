package controllers;

import java.util.*;
import models.Cell;
import models.Maze;

public class BFSController implements MazeSolver {
    private List<Cell> visitedNodes = new ArrayList<>();
    
    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
        visitedNodes.clear();

        if (grid == null || grid.length == 0) {
            return path;
        }

        Queue<Cell> queue = new LinkedList<>();
        Map<Cell, Cell> predecesores = new HashMap<>(); 

        queue.add(start);
        visitadas.add(start);
        predecesores.put(start, null); 

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            visitedNodes.add(current);
            
            if (current.equals(end)) {
                while (current != null) {
                    path.add(0, current); 
                    current = predecesores.get(current);
                }
                return path;
            }

            
            for (int[] dir : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                Cell vecino = new Cell(newRow, newCol);

                if (isValid(grid, newRow, newCol) && !visitadas.contains(vecino)) {
                    queue.add(vecino);
                    visitadas.add(vecino);
                    predecesores.put(vecino, current); 
                }
            }
        }

        return null; 
    }

    public List<Cell> getVisitedNodes() {
        return visitedNodes;
    }

    private boolean isValid(boolean[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col];
    }
}
