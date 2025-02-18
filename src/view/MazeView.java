package view;

import javax.swing.*;
import controllers.BFSController;
import controllers.DFSController;
import controllers.DPController;
import controllers.RecursiveController;
import models.Cell;
import models.Maze;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeView extends JFrame {
    private JTextField txtAncho, txtAlto;
    private JButton btnGenerar, btnBFS, btnDFS, btnRecursivo, btnDP, btnInicio, btnFin, btnReiniciar;
    private JPanel panelGrid, panelBotones;
    private JButton[][] gridButtons;
    private int ancho, alto;
    private boolean seleccionandoInicio = false;
    private boolean seleccionandoFin = false;
    private Point inicio = null;
    private Point fin = null;

    public MazeView() {
        setTitle("Laberinto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelControl = new JPanel();
        txtAncho = new JTextField("", 3);
        txtAlto = new JTextField("", 3);
        btnGenerar = new JButton("Generar Laberinto");
        btnInicio = new JButton("Seleccionar Inicio");
        btnFin = new JButton("Seleccionar Fin");
        btnReiniciar = new JButton("Reiniciar");

        panelControl.add(new JLabel("Ancho:"));
        panelControl.add(txtAncho);
        panelControl.add(new JLabel("Alto:"));
        panelControl.add(txtAlto);
        panelControl.add(btnGenerar);
        panelControl.add(btnInicio);
        panelControl.add(btnFin);
        panelControl.add(btnReiniciar);

        add(panelControl, BorderLayout.NORTH);
        panelGrid = new JPanel();
        add(panelGrid, BorderLayout.CENTER);

        panelBotones = new JPanel();
        btnBFS = new JButton("Resolver BFS");
        btnDFS = new JButton("Resolver DFS");
        btnRecursivo = new JButton("Resolver Recursivo");
        btnDP = new JButton("Resolver DP");

        panelBotones.add(btnBFS);
        panelBotones.add(btnDFS);
        panelBotones.add(btnRecursivo);
        panelBotones.add(btnDP);

        add(panelBotones, BorderLayout.SOUTH);

        btnGenerar.addActionListener(e -> generarLaberinto());
        btnInicio.addActionListener(e -> seleccionandoInicio = true);
        btnFin.addActionListener(e -> seleccionandoFin = true);
        btnReiniciar.addActionListener(e -> reiniciarLaberinto());

        // Corrección de llamadas a los controladores
        btnBFS.addActionListener(e -> resolverLaberinto(new BFSController()));
        btnDFS.addActionListener(e -> resolverLaberinto(new DFSController()));
        btnDP.addActionListener(e -> resolverLaberinto(new DPController()));
        btnRecursivo.addActionListener(e -> resolverLaberinto(new RecursiveController()));
    }

    private void generarLaberinto() {
        try {
            ancho = Integer.parseInt(txtAncho.getText());
            alto = Integer.parseInt(txtAlto.getText());
            if (ancho <= 0 || alto <= 0 || ancho > 50 || alto > 50) {
                JOptionPane.showMessageDialog(this, "Ingrese valores entre 1 y 50", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        panelGrid.removeAll();
        panelGrid.setLayout(new GridLayout(alto, ancho));
        gridButtons = new JButton[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                JButton btn = new JButton();
                btn.setBackground(Color.WHITE);
                btn.addActionListener(new ButtonClickListener(i, j));
                gridButtons[i][j] = btn;
                panelGrid.add(btn);
            }
        }
        panelGrid.revalidate();
        panelGrid.repaint();
    }

    private void reiniciarLaberinto() {
        if (gridButtons != null) {
            for (JButton[] row : gridButtons) {
                for (JButton btn : row) {
                    btn.setBackground(Color.WHITE);
                }
            }
        }
        inicio = null;
        fin = null;
        seleccionandoInicio = false;
        seleccionandoFin = false;
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = gridButtons[row][col];
            if (seleccionandoInicio) {
                if (inicio != null) {
                    gridButtons[inicio.x][inicio.y].setBackground(Color.WHITE);
                }
                inicio = new Point(row, col);
                btn.setBackground(Color.PINK);
                seleccionandoInicio = false;
            } else if (seleccionandoFin) {
                if (fin != null) {
                    gridButtons[fin.x][fin.y].setBackground(Color.WHITE);
                }
                fin = new Point(row, col);
                btn.setBackground(Color.MAGENTA);
                seleccionandoFin = false;
            } else {
                btn.setBackground(btn.getBackground() == Color.BLACK ? Color.WHITE : Color.BLACK);
            }
        }
    }

    // Método para resolver el laberinto con cualquier controlador
    private void resolverLaberinto(Object solver) {
        if (inicio == null || fin == null || gridButtons == null) {
            JOptionPane.showMessageDialog(this, "Seleccione inicio y fin antes de resolver.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean[][] grid = convertirGridABoolean(gridButtons);
        Maze maze = new Maze(grid);
        Cell startCell = new Cell(inicio.x, inicio.y);
        Cell endCell = new Cell(fin.x, fin.y);

        if (solver instanceof BFSController) {
            ((BFSController) solver).getPath(maze, grid, startCell, endCell);
        } else if (solver instanceof DFSController) {
            ((DFSController) solver).getPath(maze, grid, startCell, endCell);
        } else if (solver instanceof DPController) {
            ((DPController) solver).getPath(maze, grid, startCell, endCell);
        }
    }

    // Método para convertir la matriz de botones en una matriz booleana
    private boolean[][] convertirGridABoolean(JButton[][] gridButtons) {
        int filas = gridButtons.length;
        int columnas = gridButtons[0].length;
        boolean[][] grid = new boolean[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                grid[i][j] = gridButtons[i][j].getBackground() != Color.BLACK; // Negro es muro, otro color es camino
            }
        }
        return grid;
    }
}
