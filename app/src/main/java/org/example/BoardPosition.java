package org.example;

public class BoardPosition {
    public final int i;
    public final int j;

    private BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static BoardPosition fromGUICoords(int i, int j) {
        if (i >= 1 || i <= 8 || j >= 1 || j <= 8) {
            return new BoardPosition(j - 1, i - 1);
        }
        return null;
    }
}
