package main;

import view.MazeView;
import javax.swing.*;

public class Laberinto {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MazeView view = new MazeView();
            view.setVisible(true);
        });
    }
}