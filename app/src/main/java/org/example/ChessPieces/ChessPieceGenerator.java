package org.example.ChessPieces;

public class ChessPieceGenerator {

    public ChessPiece fromString(char piece) {

        switch (piece) {
            case '♙':
            case '♟':
                return new Pawn(piece);
            case '♖':
            case '♜':
                return new Rook(piece);
            case '♘':
            case '♞':
                return new Knight(piece);
            case '♗':
            case '♝':
                return new Bishop(piece);
            case '♕':
            case '♛':
                return new Queen(piece);
            case '♔':
            case '♚':
                return new King(piece);
        }

        return null;

    }

}
