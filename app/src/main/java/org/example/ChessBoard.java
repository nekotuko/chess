package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

public class ChessBoard {
    private ChessPiece mActivePiece;
    private ChessPiece[][] mBoard;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator();

        mBoard = new ChessPiece[8][8];

        int i_input = 0;
        int i_output = 0;

        while (i_input < mBoard.length) {
            int j_input = 0;
            int j_output = 0;
            while (j_input < boardLayout[i_input].length()) {
                String currPiece = boardLayout[i_input].substring(j_input, j_input + 2);
                if (currPiece.equals(" ")) {
                    j_input++;
                    j_output++;
                    break;
                } else {
                    mBoard[i_output][j_output] = generator.fromString(currPiece);
                    j_input = j_input + 2;
                    j_output++;
                }
            }
            i_input++;
            i_output++;
        }
    }

    char getPieceCharFromCoords(int i, int j) {
        if (mBoard[i][j] != null) {
            return mBoard[i][j].getmDisplayCharacter();
        }
        return ' ';
    }

    void toggleActivePiece(ChessPiece piece) {
        mActivePiece = piece;
    }

    void toggleActivePiece() {
        mActivePiece = null;
    }

    void movePiece(int[] sourceCoords, int[] targetCoords) {
        mBoard[targetCoords[0]][targetCoords[1]] = mBoard[sourceCoords[0]][sourceCoords[1]];
        mBoard[sourceCoords[0]][sourceCoords[1]] = null;
    }
}
