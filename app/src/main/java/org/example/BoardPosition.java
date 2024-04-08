package org.example;

public class BoardPosition {
    public final int i;
    public final int j;

    public BoardPosition(int i, int j) {
        if (false) {
            throw new IllegalArgumentException("Constructed with invalid coordinates");
        }
        this.i = i;
        this.j = j;
    }
}
