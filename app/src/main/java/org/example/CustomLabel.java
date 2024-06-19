package org.example;

import javax.swing.JLabel;

public class CustomLabel extends JLabel {

    public final BoardPosition pos;
    private boolean isActive;

    public CustomLabel(int i, int j, String str) {
        super(str);
        pos = new BoardPosition(i, j);
    }

    public void toggleActive() {
        isActive = !isActive;
    }
}
