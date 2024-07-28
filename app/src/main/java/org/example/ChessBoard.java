package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

import java.util.List;

public class ChessBoard {
    private ChessPiece[][] mBoard;

    private BoardPosition mActivePiecePosition;
    private List<BoardPosition> mActivePieceLegalMoves;

    private boolean mIsWhitesTurn = true;

    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator(this);

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
        if (positionIsOccupied(pos)) {
            return mBoard[pos.i][pos.j].getDisplayCharacter();
        } else {
            return ' ';
        }
    }

    public ChessPiece getPieceFromPos(BoardPosition pos) {
        if (positionIsOccupied(pos)) {
            return mBoard[pos.i][pos.j];
        } else {
            return null;
        }
    }

    public boolean positionIsOccupied(BoardPosition pos) {
        return (mBoard[pos.i][pos.j] != null);
    }

    boolean positionIsActive(BoardPosition pos) {
        return (pos.equals(mActivePiecePosition));
    }

    boolean positionIsALegalMove(BoardPosition pos) {
        if (mActivePieceLegalMoves != null) {
            if (mActivePieceLegalMoves.contains(pos)) {
                return true;
            }
        }
        return false;
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
            deactivateActivePiece();
            return;
        }

        // Activate a position if no position is active:
        if (mActivePiecePosition == null) {
            ChessPiece pieceAtPos = getPieceFromPos(pos);
            if (pieceAtPos != null) {
                mActivePiecePosition = pos;
                mActivePieceLegalMoves = pieceAtPos.getAllLegalPositions(pos);
            }
        } else { // Else move the piece if possible:
            movePiece(mActivePiecePosition, pos);
        }
    }

    private void deactivateActivePiece() {
        mActivePiecePosition = null;
        mActivePieceLegalMoves = null;
        return;
    }

    private void movePiece(BoardPosition source, BoardPosition target) {

        // Check if the move is legal:
        if (!mActivePieceLegalMoves.contains(target)) {
            deactivateActivePiece();
            return;
        }

        // Move the piece otherwise:

        mBoard[target.i][target.j] = mBoard[source.i][source.j];
        mBoard[source.i][source.j] = null;

        mActivePiecePosition = null;
        mActivePieceLegalMoves = null;

        mIsWhitesTurn = !mIsWhitesTurn;
    }

}
