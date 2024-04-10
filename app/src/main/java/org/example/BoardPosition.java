package org.example;

public class BoardPosition {
    public final int i;
    public final int j;

    public BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static BoardPosition fromGUICoords(int i, int j) {
        if (i >= 1 || i <= 8 || j >= 1 || j <= 8) {
            return new BoardPosition(i - 1, j - 1);
        }
        return null;
    }

    // Implement override .equals. Compares references, values, whether both are the same.
    public static boolean boardPositionIsSame(BoardPosition a, BoardPosition b) {
        return (a != null && b != null) && (a.i == b.i && a.j == b.j);
    }
}
