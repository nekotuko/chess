package org.example;

public class BoardPosition {
    public final int i;
    public final int j;

    public BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Method to check if a position is valid
    public static boolean isValid(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    // Method to return a new BoardPosition object from GUI coordinates
    public static BoardPosition fromGUICoords(int i, int j) {
        if (isValid(i - 1, j - 1)) {
            return new BoardPosition( i -1,j-1);
        }
        return null;
    }

    // Overriden method to compare if two BoardPosition objects are equal:
    @Override
    public boolean equals(Object obj) {
        // Check if the argument is a reference to the object itself
        if (this == obj) {
            return true;
        }
        // Check if the argument is not of the type 'BoardPosition'
        if (!(obj instanceof BoardPosition)) {
            return false;
        }
        // Cast the argument to 'BoardPosition' type, then compare the fields
        BoardPosition pos = (BoardPosition) obj;
        return this.i == pos.i && this.j == pos.j;
    }

}
