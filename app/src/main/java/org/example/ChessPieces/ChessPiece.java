package org.example.ChessPieces;

import org.example.ChessBoard;

import org.example.BoardPosition;

import java.util.List;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;
    private boolean mIsWhite;

    private int mPoints;

    ChessBoard mBoard;

    public ChessPiece(ChessBoard board, char pieceDisplayCharacter, int points) {
        mBoard = board;
        mDisplayCharacter = pieceDisplayCharacter;
        mPoints = points;
        mIsWhite = (pieceDisplayCharacter == '♙' || pieceDisplayCharacter == '♖' || pieceDisplayCharacter == '♘'
                || pieceDisplayCharacter == '♗' || pieceDisplayCharacter == '♕' || pieceDisplayCharacter == '♔');
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

    public int getPointValue() {
        return mPoints;
    }

    public abstract List<BoardPosition> getAllLegalPositions(BoardPosition pos);
}
