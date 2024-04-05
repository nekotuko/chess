package org.example.ChessPieces;

public class Pawn extends ChessPiece {
    Pawn(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♙');
                break;
            case "B":
                this.setmDisplayCharacter('♟');
                break;
        }
    }
}
