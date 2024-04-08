package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

public class ChessBoard {
    private ChessPiece mActivePiece;
    private ChessPiece[][] mBoard;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator();

        mBoard = new ChessPiece[8][8];

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

    void toggleActivePiece(ChessPiece piece) {
        mActivePiece = piece;
    }

    void toggleActivePiece() {
        mActivePiece = null;
    }

    void movePiece(BoardPosition sourcePos, BoardPosition targetPos) {
        mBoard[targetPos.i][targetPos.j] = mBoard[sourcePos.i][sourcePos.j];
        mBoard[sourcePos.i][sourcePos.j] = null;
    }

    void receiveInput(BoardPosition pos) {
        if (mActivePiece == null) {
            mActivePiece = mBoard[pos.i][pos.j];
        } else if (mBoard[pos.i][pos.j] == mActivePiece) {
            mActivePiece = null;
        } else {
            mBoard[pos.i][pos.j] = mActivePiece;
        }
    }
}
