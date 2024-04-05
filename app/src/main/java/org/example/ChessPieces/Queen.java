package org.example.ChessPieces;

public class Queen extends ChessPiece {
    Queen(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♕');
                break;
            case "B":
                this.setmDisplayCharacter('♛');
                break;
        }
    }
}
