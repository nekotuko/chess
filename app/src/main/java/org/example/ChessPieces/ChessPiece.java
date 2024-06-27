package org.example.ChessPieces;

import org.example.BoardPosition;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;

    public void setmDisplayCharacter(char displayCharacter) {
        this.mDisplayCharacter = displayCharacter;
    }

    public char getmDisplayCharacter() {
        return this.mDisplayCharacter;
    }

    public abstract BoardPosition[] getLegalPositions(BoardPosition pos);
}
