package models;

import java.util.Arrays;

public class Maze {
    private boolean[][] grid;
    private int size;
    private String[][] displayGrid;

    public Maze(int size) {
        this.size = size;
        grid = new boolean[size][size];
        displayGrid = new String[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(grid[i], true);
            Arrays.fill(displayGrid[i], " - ");
        }
    }
    
    public Maze(boolean[][] predefinedGrid) {
        this.size = predefinedGrid.length;
        this.grid = predefinedGrid;
        displayGrid = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                displayGrid[i][j] = grid[i][j] ? " - " : " * ";
            }
        }
    }

    public void updateMaze(Cell current, Cell start, Cell end) {
        if (current.equals(start)) {
            displayGrid[current.getRow()][current.getCol()] = " S ";
        } else if (current.equals(end)) {
            displayGrid[current.getRow()][current.getCol()] = " E ";
        } else {
            displayGrid[current.getRow()][current.getCol()] = " > ";
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void configureMaze(int[][] obstacles) {
        for (int[] obstacle : obstacles) {
            int row = obstacle[0];
            int col = obstacle[1];
            if (row >= 0 && row < size && col >= 0 && col < size) {
                grid[row][col] = false;
                displayGrid[row][col] = " * ";
            }
        }
    }

}
