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
    private JButton btnGenerar, btnBFS, btnDFS, btnRecursivo, btnDP, btnInicio, btnFin, btnReiniciar, btnModoRapido,btnComparar;
    private JPanel panelGrid, panelBotones;
    private JButton[][] gridButtons;
    private int ancho, alto;
    private boolean seleccionandoInicio = false;
    private boolean seleccionandoFin = false;
    private boolean modoRapido = false;
    private Point inicio = null;
    private Point fin = null;

    public MazeView() {
        setTitle("Laberinto");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelControl = new JPanel();
        txtAncho = new JTextField("", 3);
        txtAlto = new JTextField("", 3);
        btnGenerar = new JButton("Generar Laberinto");
        btnInicio = new JButton("Seleccionar Inicio");
        btnFin = new JButton("Seleccionar Fin");
        btnReiniciar = new JButton("Reiniciar");
        btnModoRapido = new JButton("Modo Rápido: OFF");

        panelControl.add(new JLabel("Ancho:"));
        panelControl.add(txtAncho);
        panelControl.add(new JLabel("Alto:"));
        panelControl.add(txtAlto);
        panelControl.add(btnGenerar);
        panelControl.add(btnInicio);
        panelControl.add(btnFin);
        panelControl.add(btnReiniciar);
        panelControl.add(btnModoRapido);

        add(panelControl, BorderLayout.NORTH);
        panelGrid = new JPanel();
        add(panelGrid, BorderLayout.CENTER);

        panelBotones = new JPanel();
        btnBFS = new JButton("Resolver BFS");
        btnDFS = new JButton("Resolver DFS");
        btnRecursivo = new JButton("Resolver Recursivo");
        btnDP = new JButton("Resolver DP");
        btnComparar = new JButton("Comparar Métodos");
        panelBotones.add(btnBFS);
        panelBotones.add(btnDFS);
        panelBotones.add(btnRecursivo);
        panelBotones.add(btnDP);
        panelBotones.add(btnComparar);

        add(panelBotones, BorderLayout.SOUTH);

        btnGenerar.addActionListener(e -> generarLaberinto());
        btnInicio.addActionListener(e -> seleccionandoInicio = true);
        btnFin.addActionListener(e -> seleccionandoFin = true);
        btnReiniciar.addActionListener(e -> reiniciarLaberinto());
        btnModoRapido.addActionListener(e -> cambiarModoRapido());

        btnBFS.addActionListener(e -> resolverLaberinto(new BFSController(), "BFS"));
        btnDFS.addActionListener(e -> resolverLaberinto(new DFSController(), "DFS"));
        btnDP.addActionListener(e -> resolverLaberinto(new DPController(), "DP"));
        btnRecursivo.addActionListener(e -> resolverLaberinto(new RecursiveController(), "Recursivo"));
        btnComparar.addActionListener(e -> compararMetodos());
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

    private void cambiarModoRapido() {
        modoRapido = !modoRapido;
        btnModoRapido.setText("Modo Rápido: " + (modoRapido ? "ON" : "OFF"));
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

    private void resolverLaberinto(Object solver, String metodo) {
        if (inicio == null || fin == null || gridButtons == null) {
            JOptionPane.showMessageDialog(this, "Seleccione inicio y fin antes de resolver.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean[][] grid = convertirGridABoolean(gridButtons);
        Maze maze = new Maze(grid);
        Cell startCell = new Cell(inicio.x, inicio.y);
        Cell endCell = new Cell(fin.x, fin.y);

        long startTime = System.nanoTime();
        java.util.List<Cell> path = null;

        if (solver instanceof BFSController) {
            path = ((BFSController) solver).getPath(maze, grid, startCell, endCell);
        } else if (solver instanceof DFSController) {
            path = ((DFSController) solver).getPath(maze, grid, startCell, endCell);
        } else if (solver instanceof DPController) {
            path = ((DPController) solver).getPath(maze, grid, startCell, endCell);
        } else if (solver instanceof RecursiveController) {
            path = ((RecursiveController) solver).getPath(maze, grid, startCell, endCell);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        if (path != null) {
            visualizarCaminoPasoAPaso(path);
            JOptionPane.showMessageDialog(this, metodo + " encontró el camino en " + duration + " ms y " + path.size() + " pasos.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un camino con " + metodo, "Resultado", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void visualizarCaminoPasoAPaso(java.util.List<Cell> path) {
        new Thread(() -> {
            for (Cell cell : path) {
                gridButtons[cell.getCol()][cell.getRow()].setBackground(Color.BLUE);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //repaint();
            }
        }).start();
    }

    private boolean[][] convertirGridABoolean(JButton[][] gridButtons) {
        int filas = gridButtons.length;
        int columnas = gridButtons[0].length;
        boolean[][] grid = new boolean[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                grid[i][j] = gridButtons[i][j].getBackground() != Color.BLACK;
            }
        }
        return grid;
    }
    private void compararMetodos() {
        if (inicio == null || fin == null || gridButtons == null) {
            JOptionPane.showMessageDialog(this, "Seleccione inicio y fin antes de comparar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean[][] grid = convertirGridABoolean(gridButtons);
        Maze maze = new Maze(grid);
        Cell startCell = new Cell(inicio.x, inicio.y);
        Cell endCell = new Cell(fin.x, fin.y);

        Object[] controllers = {new BFSController(), new DFSController(), new DPController(), new RecursiveController()};
        String[] metodos = {"BFS", "DFS", "DP", "Recursivo"};
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < controllers.length; i++) {
            long startTime = System.nanoTime();
            java.util.List<Cell> path = ((controllers[i] instanceof BFSController) ? ((BFSController) controllers[i]).getPath(maze, grid, startCell, endCell) :
                                         (controllers[i] instanceof DFSController) ? ((DFSController) controllers[i]).getPath(maze, grid, startCell, endCell) :
                                         (controllers[i] instanceof DPController) ? ((DPController) controllers[i]).getPath(maze, grid, startCell, endCell) :
                                         ((RecursiveController) controllers[i]).getPath(maze, grid, startCell, endCell));
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;

            if (path != null) {
                resultado.append(metodos[i]).append(" encontró el camino en ").append(duration).append(" ms y ").append(path.size()).append(" pasos.\n");
            } else {
                resultado.append(metodos[i]).append(" no encontró un camino.\n");
            }
        }

        JOptionPane.showMessageDialog(this, resultado.toString(), "Comparación de Métodos", JOptionPane.INFORMATION_MESSAGE);
    }
}

