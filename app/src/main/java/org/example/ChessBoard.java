package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

import java.util.List;

public class ChessBoard {
    private ChessPiece[][] mBoard;

    private BoardPosition mActivePiecePosition;
    private List<BoardPosition> mActivePieceLegalMoves;

    private boolean mIsWhitesTurn = true;

    private int mWhitePoints = 0;

    private boolean mKingInCheck = false;

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

        refreshPoints();
    }

    private void refreshPoints() {
        // Reset scores:
        mWhitePoints = 0;
        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[i].length; j++) {
                if (mBoard[i][j] != null) {
                    if (mBoard[i][j].isWhite()) {
                        mWhitePoints += mBoard[i][j].getPointValue();
                    } else {
                        mWhitePoints -= mBoard[i][j].getPointValue();
                    }
                }
            }
        }

        // TODO: Temp output into terminal:
        String str = (mWhitePoints < 0) ? "B: +" + mWhitePoints * (-1) : "W: +" + mWhitePoints;
        System.out.println(str);
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
        // Deactivate if the same position is clicked twice, or if the position is not a
        // legal move for a previously activated piece:
        if (pos.equals(mActivePiecePosition) || (mActivePiecePosition != null && !positionIsALegalMove(pos))) {
            mActivePiecePosition = null;
            mActivePieceLegalMoves = null;
            return;
        }

        // Activate a position if no position is active, there's a piece at clicked
        // position, and if it's current piece's turn:
        if (mActivePiecePosition == null) {
            if (positionIsOccupied(pos) && (mIsWhitesTurn == this.getPieceFromPos(pos).isWhite())) {
                ChessPiece pieceAtPos = getPieceFromPos(pos);
                if (pieceAtPos != null) {
                    mActivePiecePosition = pos;
                    mActivePieceLegalMoves = pieceAtPos.getAllLegalPositions(pos);
                }
            }
        } else { // Else move the piece, refresh points, then check if there's an active check:
            movePiece(mActivePiecePosition, pos);
            refreshPoints();
        }
    }

    private void movePiece(BoardPosition source, BoardPosition target) {
        mBoard[target.i][target.j] = mBoard[source.i][source.j];
        mBoard[source.i][source.j] = null;

        mActivePiecePosition = null;
        mActivePieceLegalMoves = null;

        mIsWhitesTurn = !mIsWhitesTurn;
    }

    private void checkForCheck() {
        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[i].length; j++) {
                
            }
        }
    }

}
