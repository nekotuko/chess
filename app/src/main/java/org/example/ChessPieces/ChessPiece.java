package org.example.ChessPieces;

import org.example.ChessBoard;

import org.example.BoardPosition;

import java.util.List;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;
    private boolean mIsWhite;

    ChessBoard mBoard;

    public ChessPiece(char pieceDisplayCharacter, ChessBoard board) {
        mDisplayCharacter = pieceDisplayCharacter;
        mIsWhite = (pieceDisplayCharacter == '♙' || pieceDisplayCharacter == '♖' || pieceDisplayCharacter == '♘'
                || pieceDisplayCharacter == '♗' || pieceDisplayCharacter == '♕' || pieceDisplayCharacter == '♔');
        mBoard = board;
    }

    public boolean isWhite() {
        return mIsWhite;
    }

    public char getDisplayCharacter() {
        return mDisplayCharacter;
    }

    public boolean canTake(ChessPiece piece) {
        return (piece.isWhite() != this.isWhite());
    }

    public abstract List<BoardPosition> getAllLegalPositions(BoardPosition pos);
}
