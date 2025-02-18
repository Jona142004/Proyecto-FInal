/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
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
        
        txtAncho.addActionListener(e -> txtAlto.requestFocus());

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
    }

    private void generarLaberinto() {
        ancho = Integer.parseInt(txtAncho.getText());
        alto = Integer.parseInt(txtAlto.getText());
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
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    gridButtons[i][j].setBackground(Color.WHITE);
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
                btn.setBackground(Color.pink);
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
}
