package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

public class ChessBoard {
    private ChessPiece[][] mBoard;

    private BoardPosition mActivePiecePosition;
    private boolean[][] mActivePieceLegalMoves;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator();

        // TODO: Check if it's useful to declare the size of 'mBoard' dynamically
        // instead of a fixed 8x8 size
        mBoard = new ChessPiece[boardLayout.length][boardLayout[0].length()];

        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[i].length; j++) {
                char currPiece = boardLayout[i].charAt(j);

                // TODO: flip 'i' to match GUI ordering:
                mBoard[7 - i][j] = generator.fromString(currPiece);
            }
        }
    }

    char getPieceCharFromPos(BoardPosition pos) {
        if (pos.isValid() && mBoard[pos.i][pos.j] != null) {
            return mBoard[pos.i][pos.j].getmDisplayCharacter();
        } else {
            return ' ';
        }
    }

    ChessPiece getPieceFromPos(BoardPosition pos) {
        if (pos.isValid() && mBoard[pos.i][pos.j] != null) {
            return mBoard[pos.i][pos.j];
        } else {
            return null;
        }
    }

    boolean positionIsOccupied(BoardPosition pos) {
        return (mBoard[pos.i][pos.j] != null);
    }

    boolean positionIsActive(BoardPosition pos) {
        return (pos.equals(mActivePiecePosition));
    }

    boolean positionIsALegalMove(BoardPosition pos) {
        if (mActivePieceLegalMoves != null) {
            return mActivePieceLegalMoves[pos.i][pos.j];
        } else {
            return false;
        }
    }

    void receiveInput(BoardPosition pos) {
        // Avoid even passing pos if it's null
        // TODO this can never be null as it's only called by CustomLabel listener, that
        // only stores valid BoardPositions
        if (pos == null) {
            return;
        }

        // Deactivate active piece
        if (pos.equals(mActivePiecePosition)) {
            mActivePiecePosition = null;
            mActivePieceLegalMoves = null;
            return;
        }

        // Activate a position if no position is active:
        if (mActivePiecePosition == null) {
            ChessPiece pieceAtPos = getPieceFromPos(pos);
            if (pieceAtPos != null) {
                mActivePiecePosition = pos;
                mActivePieceLegalMoves = pieceAtPos.getAllPossiblePositions(pos);
            }
        } else { // Else move the piece if possible:

            mBoard[pos.i][pos.j] = mBoard[mActivePiecePosition.i][mActivePiecePosition.j];
            mBoard[mActivePiecePosition.i][mActivePiecePosition.j] = null;
            mActivePiecePosition = null;

            movePiece(mActivePiecePosition, pos);
        }
    }

    void movePiece(BoardPosition source, BoardPosition target) {

        mActivePiecePosition = null;
        mActivePieceLegalMoves = null;
    }

    // boolean[][] getActivePieceLe galPositions() {
    // boolean[][] visited = new boolean[8][8];
    // boolean[][] activePieceLegalMoves = new boolean[8][8];

    // BoardPosition origin = mActivePiecePosition;
    // visited[origin.i][origin.j] = true;

    // }

}
