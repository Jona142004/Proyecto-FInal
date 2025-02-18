package models;

import java.util.Objects;

public class Cell {
    public int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return " [" + row + ", " + col + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Mismo objeto en memoria
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // No es de la misma clase
        }

        Cell objC = (Cell) obj;

        return row == objC.row && col == objC.col;
    }


    @Override
    public int hashCode(){
        return Objects.hash(row,col);
    }
    
}
