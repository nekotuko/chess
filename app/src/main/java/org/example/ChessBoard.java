package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

public class ChessBoard {
    private BoardPosition mActivePiecePosition;
    private ChessPiece[][] mBoard;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator();

        // TODO: Check if it's useful to declare the size of 'mBoard' dynamically instead of a fixed 8x8 size
        mBoard = new ChessPiece[boardLayout.length][boardLayout[0].length()];

        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[i].length; j++) {
                char currPiece = boardLayout[i].charAt(j);

                mBoard[i][j] = generator.fromString(currPiece);
            }
        }
    }

    char getPieceCharFromCoords(int i, int j) {
        if (mBoard[i][j] != null) {
            return mBoard[i][j].getmDisplayCharacter();
        }
        return ' ';
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
        if (mActivePiecePosition == null) {
            if (mBoard[pos.i][pos.j] != null) {
                mActivePiecePosition = pos;
            }
        } else {
            mBoard[pos.i][pos.j] = mBoard[mActivePiecePosition.i][mActivePiecePosition.j];
            mBoard[mActivePiecePosition.i][mActivePiecePosition.j] = null;
            mActivePiecePosition = null;
        }

        // if (mActivePiecePosition == null) {
        // mActivePiecePosition = pos;
        // } else if (BoardPosition.boardPositionIsSame(pos, mActivePiecePosition)) {
        // mActivePiecePosition = null;
        // } else if (mActivePiecePosition != null) {
        // mBoard[pos.i][pos.j] =
        // mBoard[mActivePiecePosition.i][mActivePiecePosition.j];
        // mBoard[mActivePiecePosition.i][mActivePiecePosition.j] = null;
        // mActivePiecePosition = null;
        // }
    }
}
