package org.example;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CustomLabel extends JLabel {

    public final BoardPosition mPos;

    private Color mBackgroundColor;

    private App mMainApp;
    private ChessBoard mBoard;

    public CustomLabel(App app, ChessBoard board, int i, int j, String str) {
        // Pass the string to the JLabel constructor:
        super(str);

        // Store main app and board reference:
        mMainApp = app;
        mBoard = board;

        // Store the position of the label:
        mPos = BoardPosition.fromCoords(i, j);

        // Misc label settings:
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(this.getFont().deriveFont(50.0f));
        this.setOpaque(true);

        // Set the background color based on the position:
        if ((i + j) % 2 == 0) {
            mBackgroundColor = Color.white;
        } else {
            mBackgroundColor = Color.lightGray;
        }
        this.setBackground(mBackgroundColor);

        // Add a mouse listener to the label:
        addMouseListener(new OnClickEvent(this));
    }

    private class OnClickEvent extends MouseAdapter {
        private CustomLabel mLabel;

        public OnClickEvent(CustomLabel label) {
            mLabel = label;
        }

        public void mouseClicked(MouseEvent e) {
            // Pass input to the chess board and let it handle logic:
            mBoard.receiveInput(mPos);

            // Update GUI:
            mMainApp.refreshGuiSquares();
        }
    }

    // Change diplay of CustomLabel based on whether the piece is active:
    public void updateActive() {
        if (mBoard.positionIsActive(mPos)) {
            this.setBackground(Color.cyan);
        } else {
            this.setBackground(mBackgroundColor);
        }
    }

    public void refresh() {
        // Get display character:
        this.setText(Character.toString(mBoard.getPieceCharFromCoords(mPos)));

        // Check if is active:
        updateActive();
    }
}
