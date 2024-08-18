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
                return new Pawn(mBoard, piece);
            case '♖':
            case '♜':
                return new Rook(mBoard, piece);
            case '♘':
            case '♞':
                return new Knight(mBoard, piece);
            case '♗':
            case '♝':
                return new Bishop(mBoard, piece);
            case '♕':
            case '♛':
                return new Queen(mBoard, piece);
            case '♔':
            case '♚':
                return new King(mBoard, piece);
        }

        return null;
    }

}
