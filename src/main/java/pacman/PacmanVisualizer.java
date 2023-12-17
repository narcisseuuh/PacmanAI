package pacman;

import javax.swing.*;
import java.awt.*;

public class PacmanVisualizer {
    public static final int CELL_WIDTH = 40;
    public static final int CELL_HEIGHT = 40;

    protected final int height;
    protected final int width;
    protected JFrame mainFrame;
    protected JLabel[][] labels;

    public PacmanVisualizer(int height, int width) {
        this.height = height;
        this.width = width;
        this.mainFrame = new JFrame("Intelligent Pacman");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(height, width));
        mainFrame.setLocationRelativeTo(null);
        labels = new JLabel[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                JLabel label = getLabel(' ');
                labels[row][col] = label;
                mainFrame.add(label);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JLabel getLabel(char c) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
        setColorLabel(c, label);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }

    protected static void setColorLabel(char c, JLabel label) {
        switch (c) {
            case '%':
                label.setBackground(Color.BLUE);
                break;
            case 'P':
                label.setBackground(Color.YELLOW);
                break;
            case 'V':
                label.setBackground(Color.GREEN);
                break;
            case '.':
                label.setBackground(Color.BLACK);
                break;
            case 'G':
                label.setBackground(Color.PINK);
                break;
            default:
                label.setBackground(Color.RED);
                break;
        }
        label.repaint();
    }

    public void update(PacmanState pacman) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Position currentPos = new Position(row, col);
                setColorLabel(pacman.get(currentPos), labels[row][col]);
            }
        }
        setColorLabel('P', labels[pacman.findPacman().getRow()][pacman.findPacman().getCol()]);
        //mainFrame.repaint();
    }
}
