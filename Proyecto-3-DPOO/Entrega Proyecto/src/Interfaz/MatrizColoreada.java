package Interfaz;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class MatrizColoreada extends JFrame {

    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};

    public MatrizColoreada() {
        setTitle("Matriz Coloreada");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int rows = 30; // Número de filas
        int cols = 50; // Número de columnas
        int squareSize = 20; // Tamaño de cada cuadrado
        int separation = 3; // Separación entre cuadrados

        // Número que determina el color (puede ser un parámetro)
        int colorNumber = 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = j * (squareSize + separation);
                int y = i * (squareSize + separation);

                g2d.setColor(COLORS[colorNumber % COLORS.length]);
                g2d.fillRect(x, y, squareSize, squareSize);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, squareSize, squareSize);
            }
        }
    }
}
