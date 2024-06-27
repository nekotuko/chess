package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

public class ChessBoard {
    private BoardPosition mActivePiecePosition;
    private ChessPiece[][] mBoard;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator();

        // TODO: Check if it's useful to declare the size of 'mBoard' dynamically
        // instead of a fixed 8x8 size
        mBoard = new ChessPiece[boardLayout.length][boardLayout[0].length()];

        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[i].length; j++) {
                char currPiece = boardLayout[i].charAt(j);

                mBoard[i][j] = generator.fromString(currPiece);
            }
        }
    }

    char getPieceCharFromCoords(BoardPosition pos) {
        if (pos.isValid() && mBoard[pos.i][pos.j] != null) {
            return mBoard[pos.i][pos.j].getmDisplayCharacter();
        } else {
            return ' ';
        }
    }

    boolean positionIsActive(BoardPosition pos) {
        return (pos.equals(mActivePiecePosition));
    }

    void receiveInput(BoardPosition pos) {
        // Avoid even passing pos if it's null
        if (pos == null) {
            return;
        }

        // Deactivaate active piece
        if (pos.equals(mActivePiecePosition)) {
            mActivePiecePosition = null;
            return;
        }

        // Activate a position if no position is active:
        if (mActivePiecePosition == null) {
            if (mBoard[pos.i][pos.j] != null) {
                mActivePiecePosition = pos;
            }
        } else { // Else move the piece if possible:
            mBoard[pos.i][pos.j] = mBoard[mActivePiecePosition.i][mActivePiecePosition.j];
            mBoard[mActivePiecePosition.i][mActivePiecePosition.j] = null;
            mActivePiecePosition = null;
        }
    }

    
}
