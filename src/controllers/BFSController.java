package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import controllers.MazeSolver;
import models.Cell;
import models.Maze;

public class BFSController implements MazeSolver {

    @Override
    public List<Cell> getPath(Maze maze,boolean[][] grid, Cell start, Cell end) {
        System.out.println("Implementacion Recursiva");
            List<Cell> path = new ArrayList<>();
            Set<Cell> visitadas = new HashSet<>();
            Set<Cell> recorrido = new LinkedHashSet<>();

            if(grid == null || grid.length == 0){
                return path;
            }

            /*if(findPath(grid, start.row, start.col, end, path, visitadas)){
                return path;
            }  
            
            return new ArrayList<>(); */
            findPath(maze, grid, start.row, start.col, end, end, path, visitadas);
            List<Cell> exploredList = new ArrayList<>(visitadas);
            return path.isEmpty()? exploredList:path;
            

            
    }

    private boolean findPath(Maze maze, boolean[][] grid, int row, int col, Cell end, Cell start, List<Cell> path, Set<Cell> visitadas) {
        Cell cell = new Cell(row, col);
        if (row < 0 || col <0 || row >= grid.length || col>= grid[0].length || !grid[row] [col]) {
            
            return false;  
        }
        if (visitadas.contains(cell)) {
            return false;
        }
        visitadas.add(cell);
        //maze.updateMaze(cell,start,end);

        //Explorar direcciones
        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }
        if (findPath(maze, grid, row + 1, col, end, cell, path,visitadas)) {
            path.add(cell);
            return true;
        }
        
        if (findPath(maze, grid, row, col + 1, end, cell, path,visitadas)) {
            path.add(cell);
            return true;
        }
        if (findPath(maze, grid, row , col -1, end, cell, path,visitadas)) { //arriba
            path.add(cell);
            return true;
        } 
        if (findPath(maze, grid, row -1 , col  , end, cell, path,visitadas)) { //izquierda
            path.add(cell);
            return true;
        }
        visitadas.remove(cell);
        path.remove(cell);
        return false;

    }
    
}
