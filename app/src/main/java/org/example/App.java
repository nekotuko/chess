/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 1. Make it so when you open the App, it shows an empty grid with position
 * labels and different colors for the positions.
 *
 * 2. Add pieces to the board. They don't have to move, just exist in the right
 * positions.
 *
 * 3. Implement moving functionality where you can move any piece anywhere,
 * forget about the rules.
 *
 * 4. Add rules for each piece so it can only be moved legally.
 */
public class App {

    private JFrame frame;

    JPanel panel;

    private String[] grid = new String[] {
            " abcdefgh ",
            "8        8",
            "7        7",
            "6        6",
            "5        5",
            "4        4",
            "3        3",
            "2        2",
            "1        1",
            " abcdefgh ",
    };

    private class OnClickEvent extends MouseAdapter {
        private ChessBoard mBoard;

        public OnClickEvent(ChessBoard board) {
            mBoard = board;
        }

        public void mouseClicked(MouseEvent e) {
            // JLabel label = (JLabel) e.getComponent();
            // Point labelPos = label.getLocation();
            System.out.println(e.getX() + " " + e.getY());
            System.out.println(panel.getWidth() + " " + panel.getWidth());
            int x = e.getX() / (panel.getWidth() / 10);
            int y = e.getY() / (panel.getHeight() / 10);

            System.out.println("Click detected: " + x + " " + y);
            mBoard.receiveInput(new BoardPosition(x, y));

            refreshBoardGui(mBoard);
        }
    }

    private void refreshBoardGui(ChessBoard board) {

        int i = 0;

        Component[] labels = panel.getComponents();

        while (i < grid.length) {
            int j = 0;
            while (j < grid[i].length()) {
                if ((i > 0 && i < grid.length - 1) && (j > 0 && j < grid[0].length() - 1)) {
                    JLabel currLabel = (JLabel) labels[i * 10 + j];
                    currLabel.setText(Character.toString(board.getPieceCharFromCoords(i - 1, j - 1)));
                }
                j++;
            }
            i++;
        }

    }

    private void initGui(ChessBoard board) {

        frame = new JFrame("Chess");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(grid.length, grid[0].length()));
        panel.addMouseListener(new OnClickEvent(board));

        // This appears to be the resolution of the UI window.
        panel.setPreferredSize(new Dimension(800, 800));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                String currLabel = grid[i].substring(j, j + 1);

                if ((i == 0 || i == grid.length - 1) || (j == 0 || j == grid[0].length() - 1)) {
                    panel.add(new JLabel(currLabel, JLabel.CENTER));
                } else {
                    JLabel gridRectangle = new JLabel(Character.toString(board.getPieceCharFromCoords(i - 1, j - 1)));
                    // gridRectangle.addMouseListener(new OnClickEvent(board));
                    gridRectangle.setHorizontalAlignment(JLabel.CENTER);
                    gridRectangle.setFont(gridRectangle.getFont().deriveFont(50.0f));
                    gridRectangle.setOpaque(true);

                    if ((i + j) % 2 == 0) {
                        gridRectangle.setBackground(Color.white);
                    } else {
                        gridRectangle.setBackground(Color.lightGray);
                    }

                    panel.add(gridRectangle);
                }

            }
        }

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Started the Chess app.");

        String[] boardLayout = new String[] {
                "♜♞♝♛♚♝♞♜",
                "♟♟♟♟♟♟♟♟",
                "        ",
                "        ",
                "        ",
                "        ",
                "♙♙♙♙♙♙♙♙",
                "♖♘♗♕♔♗♘♖",
        };

        ChessBoard board = new ChessBoard(boardLayout);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App().initGui(board);
            }
        });
    }
}
