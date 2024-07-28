package org.example.ChessPieces;

import org.example.ChessBoard;

// This class generates pieces from the list of allowable characters.
public class ChessPieceGenerator {
    private ChessBoard mBoard;

    public ChessPieceGenerator(ChessBoard board) {
        mBoard = board;
    }

    public ChessPiece fromString(char piece) {

        switch (piece) {
            case '♙':
            case '♟':
                return new Pawn(piece, mBoard);
            case '♖':
            case '♜':
                return new Rook(piece, mBoard);
            case '♘':
            case '♞':
                return new Knight(piece, mBoard);
            case '♗':
            case '♝':
                return new Bishop(piece, mBoard);
            case '♕':
            case '♛':
                return new Queen(piece, mBoard);
            case '♔':
            case '♚':
                return new King(piece, mBoard);
        }

        return null;
    }

}
