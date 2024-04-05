package org.example.ChessPieces;

public class Bishop extends ChessPiece {
    Bishop(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♗');
                break;
            case "B":
                this.setmDisplayCharacter('♝');
                break;
        }
    }
}
