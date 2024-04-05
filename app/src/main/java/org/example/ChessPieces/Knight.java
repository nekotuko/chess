package org.example.ChessPieces;

public class Knight extends ChessPiece {
    Knight(String pieceColor) {
        switch (pieceColor) {
            case "W":
                this.setmDisplayCharacter('♘');
                break;
            case "B":
                this.setmDisplayCharacter('♞');
                break;
        }
    }
}
