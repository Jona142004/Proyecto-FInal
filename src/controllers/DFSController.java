package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import controllers.MazeSolver;
import models.Cell;
import models.Maze;

public class DFSController implements MazeSolver {

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        System.out.println("Implementacion con BFS");
        Queue<Cell> queue = new LinkedList<>();
        Map<Cell, Cell> predecesores = new HashMap<>();
        List<Cell> path = new ArrayList<>();

        queue.add(start);
        predecesores.put(start, null);

        while (!queue.isEmpty()) {
            Cell actual = queue.poll();
            // Cuando ya llego
            if (actual.equals(end)) {
                // reconstruir el camino desde el destino hacia el inicio
                while (actual != null) {
                    path.add(0, actual);
                    actual = predecesores.get(actual);
                    
                }
                return path;
            }
            // Explorar 4 direcciones
            for (int[] dir : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
                int newRow = actual.row + dir[0];
                int newCol = actual.col + dir[1];
                Cell vecino = new Cell(newRow, newCol);

                if (isValid(grid, newRow, newCol) && !predecesores.containsKey(vecino)) {
                    queue.add(vecino);
                    predecesores.put(vecino, actual);
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean isValid(boolean[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col <grid[0].length && grid[row][col];
    }

}
