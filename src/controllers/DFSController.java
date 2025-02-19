package controllers;

import java.util.*;
import models.Cell;
import models.Maze;

public class DFSController implements MazeSolver {

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        Stack<Cell> stack = new Stack<>();
        Map<Cell, Cell> predecesores = new HashMap<>();
        List<Cell> path = new ArrayList<>();

        stack.push(start);  
        predecesores.put(start, null);

        while (!stack.isEmpty()) {
            Cell actual = stack.pop();  

            if (actual.equals(end)) {
                while (actual != null) {
                    path.add(actual);  
                    actual = predecesores.get(actual);
                }
                Collections.reverse(path); 
                return path;
            }

            for (int[] dir : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
                int newRow = actual.row + dir[0];
                int newCol = actual.col + dir[1];
                Cell vecino = new Cell(newRow, newCol);

                if (isValid(grid, newRow, newCol) && !predecesores.containsKey(vecino)) {
                    stack.push(vecino);  
                    predecesores.put(vecino, actual); 
                }
            }
        }
        return new ArrayList<>();  
    }

    private boolean isValid(boolean[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col];
    }
}
