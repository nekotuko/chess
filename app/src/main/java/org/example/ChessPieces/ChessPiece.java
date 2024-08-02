package org.example.ChessPieces;

import org.example.ChessBoard;

import org.example.BoardPosition;

import java.util.List;

// A generic class for all chess pieces.
public abstract class ChessPiece {
    private char mDisplayCharacter;
    private char mChessNotation;
    private boolean mIsWhite;

    private int mPoints;

    ChessBoard mBoard;

    public ChessPiece(ChessBoard board, char displayCharacter, char chessNotation, int points) {
        mBoard = board;
        mDisplayCharacter = displayCharacter;
        mPoints = points;
        mIsWhite = (displayCharacter == '♙' || displayCharacter == '♖' || displayCharacter == '♘'
                || displayCharacter == '♗' || displayCharacter == '♕' || displayCharacter == '♔');
    }

    public boolean isWhite() {
        return mIsWhite;
    }

    public char getDisplayCharacter() {
        return mDisplayCharacter;
    }

    public char getChessNotation() {
        return mChessNotation;
    }

    public boolean canTake(ChessPiece piece) {
        return (piece.isWhite() != this.isWhite());
    }

    public int getPointValue() {
        return mPoints;
    }

    public abstract List<BoardPosition> getAllLegalPositions();
}
