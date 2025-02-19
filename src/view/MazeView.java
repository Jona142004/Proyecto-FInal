package view;

import javax.swing.*;
import java.util.List;
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
    private JButton btnGenerar, btnBFS, btnDFS, btnRecursivo, btnDP, btnInicio, btnFin, btnReiniciar, btnModoRapido, btnComparar;
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
        setLocationRelativeTo(null);
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

        panelControl.setBackground(new Color(176, 217, 250));

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

        panelBotones.setBackground(new Color(176, 217, 250));

        add(panelBotones, BorderLayout.SOUTH);

        txtAncho.addActionListener(e -> txtAlto.requestFocus());
        txtAlto.addActionListener(e -> {
            btnGenerar.requestFocus();  
            btnGenerar.doClick();        
        });
        btnGenerar.addActionListener(e -> generarLaberinto());
        btnInicio.addActionListener(e -> seleccionandoInicio = true);
        btnFin.addActionListener(e -> seleccionandoFin = true);
        btnReiniciar.addActionListener(e -> reiniciarLaberinto());
        btnModoRapido.addActionListener(e -> cambiarModoRapido());

        // Corrección de llamadas a los controladores
        btnBFS.addActionListener(e -> resolverLaberinto(new BFSController()));
        btnDFS.addActionListener(e -> resolverLaberinto(new DFSController()));
        btnDP.addActionListener(e -> resolverLaberinto(new DPController()));
        btnRecursivo.addActionListener(e -> resolverLaberinto(new RecursiveController()));
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
            JOptionPane.showMessageDialog(this, "Ingrese valores entre 1 y 50", "Error", JOptionPane.ERROR_MESSAGE);
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
                btn.setBackground(new Color(92, 64, 207));
                seleccionandoInicio = false;
            } else if (seleccionandoFin) {
                if (fin != null) {
                    gridButtons[fin.x][fin.y].setBackground(Color.WHITE);
                }
                fin = new Point(row, col);
                btn.setBackground(new Color(76, 64, 122));
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
    
        new Thread(() -> {
            long startTime = System.nanoTime();
            List<Cell> visitados = null;
            List<Cell> camino = null;
    
            if (solver instanceof BFSController) {
                visitados = ((BFSController) solver).getVisitedNodes();
                camino = ((BFSController) solver).getPath(maze, grid, startCell, endCell);
            } else if (solver instanceof DFSController) {
                camino = ((DFSController) solver).getPath(maze, grid, startCell, endCell);
            } else if (solver instanceof DPController) {
                visitados = ((DPController) solver).getVisitedNodes();
                camino = ((DPController) solver).getPath(maze, grid, startCell, endCell);
            } else if (solver instanceof RecursiveController) {
                visitados = ((RecursiveController) solver).getVisitedNodes();
                camino = ((RecursiveController) solver).getPath(maze, grid, startCell, endCell);
            }
    
            if (visitados != null) {
                for (Cell c : visitados) {
                    int delay = modoRapido ? 0 : 100;
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SwingUtilities.invokeLater(() -> gridButtons[c.row][c.col].setBackground(new Color(207, 55, 73)));
                }
            }
            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;
            
            if (camino == null || camino.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay camino posible.", "Resultado", JOptionPane.WARNING_MESSAGE);
            } else {
                for (Cell c : camino) {
                    int delay = modoRapido ? 0 : 200;
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SwingUtilities.invokeLater(() -> gridButtons[c.row][c.col].setBackground(new Color(53, 207, 87)));
                }
            }
            
        }).start();
    }
    

    // Método para convertir la matriz de botones en una matriz booleana
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
            List<Cell> path = ((controllers[i] instanceof BFSController) ? ((BFSController) controllers[i]).getPath(maze, grid, startCell, endCell) :
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
