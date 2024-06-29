package org.example.ChessPieces;

import org.example.BoardPosition;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;
    private boolean mIsWhite;

    public ChessPiece(char pieceDisplayCharacter) {
        mDisplayCharacter = pieceDisplayCharacter;
        mIsWhite = mDisplayCharacterIsWhite(pieceDisplayCharacter);
    }

    private boolean mDisplayCharacterIsWhite(char pieceDisplayCharacter) {
        return (pieceDisplayCharacter == '♙' || pieceDisplayCharacter == '♖' || pieceDisplayCharacter == '♘' || pieceDisplayCharacter == '♗' || pieceDisplayCharacter == '♕' || pieceDisplayCharacter == '♔');
    }

    public boolean isWhite() {
        return mIsWhite;
    }

    public char getmDisplayCharacter() {
        return this.mDisplayCharacter;
    }

    public abstract boolean[][] getAllPossiblePositions(BoardPosition pos);
}
