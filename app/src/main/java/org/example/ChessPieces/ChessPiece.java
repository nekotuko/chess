package org.example.ChessPieces;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;

    public void setmDisplayCharacter(char displayCharacter) {
        this.mDisplayCharacter = displayCharacter;
    }

    public char getmDisplayCharacter() {
        return this.mDisplayCharacter;
    }

    public abstract int[][] getLegalPositions(int[] currPos);

    // For premoves, implement later:
    public abstract int[][] getAllPossiblePositions();
}
