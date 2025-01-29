package matrix;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MatrixRain extends JPanel {
   
	private static final long serialVersionUID = 1L;
	
	private final int width = 800;
    private final int height = 600;
    private final int fontSize = 20;
    private final int columns = width / fontSize;
    private final char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final int[] yPositions = new int[columns];
    private final Random random = new Random();

    public MatrixRain() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        
        
        Timer timer = new Timer(50, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0, 0, 0, 25)); // Fundo semitransparente
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Monospaced", Font.BOLD, fontSize));

        for (int i = 0; i < columns; i++) {
            char c = characters[random.nextInt(characters.length)];
            int x = i * fontSize;
            int y = yPositions[i] * fontSize;
            g2d.drawString(String.valueOf(c), x, y);
            
            if (y > height && random.nextInt(10) > 7) {
                yPositions[i] = 0;
            } else {
                yPositions[i]++;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix Rain");
        MatrixRain matrixRain = new MatrixRain();
        frame.add(matrixRain);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


