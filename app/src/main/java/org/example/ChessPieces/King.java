package org.example.ChessPieces;

public class King extends ChessPiece {
    King(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♔');
                break;
            case "B":
                this.setmDisplayCharacter('♚');
                break;
        }
    }
}
