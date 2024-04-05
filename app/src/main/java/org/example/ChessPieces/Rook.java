package org.example.ChessPieces;

public class Rook extends ChessPiece {
    Rook(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♖');
                break;
            case "B":
                this.setmDisplayCharacter('♜');
                break;
        }
    }
}
