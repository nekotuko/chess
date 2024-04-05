package org.example.ChessPieces;

public class ChessPieceGenerator {

    // Board layout represented as a string. Defined as pairs of letters:
    // Prefix:
    // 'W' - white; 'B' - black.
    // Suffix:
    // 'R' - rook; 'N' - knight; 'B' - bishop; 'Q' - queen; 'K' - king;
    // Space - means no piece.

    public ChessPiece fromString(String str) {

        ChessPiece piece = null;

        if (str.length() == 2) {
            String pieceColor = str.substring(0, 1);
            String pieceType = str.substring(1, 2);

            switch (pieceType) {
                case "P":
                    piece = new Pawn(pieceColor);
                    break;
                case "R":
                    piece = new Rook(pieceColor);
                    break;
                case "N":
                    piece = new Knight(pieceColor);
                    break;
                case "B":
                    piece = new Bishop(pieceColor);
                    break;
                case "Q":
                    piece = new Queen(pieceColor);
                    break;
                case "K":
                    piece = new King(pieceColor);
                    break;
            }
        }

        return piece;

    }

}
