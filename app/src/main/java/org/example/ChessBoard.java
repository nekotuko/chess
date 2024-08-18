package org.example;

import org.example.ChessPieces.ChessPiece;
import org.example.ChessPieces.ChessPieceGenerator;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class ChessBoard {

    private class Triplet {
        ChessPiece mMovedPiece;
        ChessPiece mCapturedPiece;
        BoardPosition mTargetPos;

        Triplet(ChessPiece movedPiece, ChessPiece capturedPiece, BoardPosition targetPos) {
            mMovedPiece = movedPiece;
            mCapturedPiece = capturedPiece;
            mTargetPos = targetPos;
        }
    }

    // Bidirectional Piece and Position Lookup Map:
    private class BiMap {
        private final Map<ChessPiece, BoardPosition> mPiecePositionMap = new HashMap<>();
        private final Map<BoardPosition, ChessPiece> mPositionPieceMap = new HashMap<>();

        void put(ChessPiece piece, BoardPosition pos) {
            mPiecePositionMap.put(piece, pos);
            mPositionPieceMap.put(pos, piece);
        }

        BoardPosition getPositionOfPiece(ChessPiece piece) {
            return mPiecePositionMap.get(piece);
        }

        ChessPiece getPieceAtPosition(BoardPosition pos) {
            return mPositionPieceMap.get(pos);
        }

        void remove(ChessPiece piece) {
            BoardPosition pos = getPositionOfPiece(piece);
            mPiecePositionMap.remove(piece);
            mPositionPieceMap.remove(pos);
        }

        void remove(BoardPosition pos) {
            ChessPiece piece = getPieceAtPosition(pos);
            mPiecePositionMap.remove(piece);
            mPositionPieceMap.remove(pos);
        }
    }

    private final BiMap mBoardMap = new BiMap();
    private final Map<ChessPiece, List<BoardPosition>> mPieceLegalMovesMap = new HashMap<>();

    private final Stack<Triplet> mMoveHistory = new Stack<>();
    private ChessPiece mActivePiece;

    private boolean mIsWhitesTurn = true;

    private int mWhitePoints = 0;

    private ChessPiece mKingIsInCheck;

    private boolean mWhiteKingHasMoved;

    private boolean mBlackKingHasMoved;

    // Constructor:
    ChessBoard(String[] boardLayout) {

        ChessPieceGenerator generator = new ChessPieceGenerator(this);
        BoardPosition currPosOnBoard;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece newPiece = generator.fromString(boardLayout[i].charAt(j));

                if (newPiece != null) {
                    // BoardPosition's 'i' is flipped to match the board layout:
                    currPosOnBoard = BoardPosition.fromCoords(7 - i, j);

                    mBoardMap.put(newPiece, currPosOnBoard);
                    mPieceLegalMovesMap.put(newPiece, newPiece.getAllLegalPositions());
                }
            }
        }

        refreshPoints();
    }

    // Getters for exernal classes:
    public char getPieceCharFromPos(BoardPosition pos) {
        ChessPiece piece = mBoardMap.getPieceAtPosition(pos);
        if (piece != null) {
            return piece.getDisplayCharacter();
        } else {
            return ' ';
        }
    }

    public BoardPosition getPositionOfPiece(ChessPiece piece) {
        return mBoardMap.getPositionOfPiece(piece);
    }

    public ChessPiece getPieceFromPos(BoardPosition pos) {
        return mBoardMap.getPieceAtPosition(pos);
    }

    public boolean positionIsOccupied(BoardPosition pos) {
        return mBoardMap.getPieceAtPosition(pos) != null;
    }

    public boolean positionIsALegalMoveForActivePiece(BoardPosition pos) {
        if (mActivePiece != null) {
            return mPieceLegalMovesMap.get(mActivePiece).contains(pos);
        } else {
            return false;
        }
    }

    // Method to refresh the points on the board:
    private void refreshPoints() {
        // Reset scores:
        mWhitePoints = 0;

        // Calculate points:
        for (ChessPiece piece : mBoardMap.mPiecePositionMap.keySet()) {
            if (piece.isWhite()) {
                mWhitePoints += piece.getPointValue();
            } else {
                mWhitePoints -= piece.getPointValue();
            }
        }

        // TODO: Temp output into terminal:
        String str = (mWhitePoints < 0) ? "B: +" + mWhitePoints * (-1) : "W: +" + mWhitePoints;
        System.out.println(str);
    }

    boolean positionIsActive(BoardPosition pos) {
        return (pos.equals(mBoardMap.getPositionOfPiece(mActivePiece)));
    }

    void receiveInput(BoardPosition clickedPos) {
        ChessPiece clickedPiece = mBoardMap.getPieceAtPosition(clickedPos);
        // If there's already an active piece:
        if (mActivePiece != null) {
            // Deactivate if the active piece is clicked twice, or if the position is not a
            // legal move for the active piece:
            if (clickedPiece == mActivePiece || !mPieceLegalMovesMap.get(mActivePiece).contains(clickedPos)) {
                mActivePiece = null;
                return;
            } else { // Else, move the piece, update legal moves, refresh points, then check if
                // there's an active check:
                movePiece(mActivePiece, clickedPos);
                mActivePiece = null;
                mIsWhitesTurn = !mIsWhitesTurn;
                updateAllLegalMoves();
                refreshPoints();
                checkForCheck();
            }
        } else { // If there's no active piece, activate:
            if (clickedPiece != null && clickedPiece.isWhite() == mIsWhitesTurn) {
                mActivePiece = clickedPiece;
            }
        }
    }

    // TODO: Check if movePiece is better as a 'ChessBoard' or 'BiMap' method.
    // Putting it under 'BiMap' would require making 'mPieceLegalMovesMap' a field
    // of 'BiMap'. Removing pieces in one of the methods within 'ChessBoard' feels
    // more bug prone.
    void movePiece(ChessPiece piece, BoardPosition targetPos) {
        // If there's a piece at the target position, remove it:
        ChessPiece pieceToRemove = mBoardMap.getPieceAtPosition(targetPos);
        if (pieceToRemove != null) {
            mBoardMap.remove(pieceToRemove);
            mPieceLegalMovesMap.remove(pieceToRemove);
        }
        mMoveHistory.push(new Triplet(piece, pieceToRemove, targetPos));
        mBoardMap.remove(piece);
        mBoardMap.put(piece, targetPos);
        // TODO: Print last move to terminal:
        System.out.println(mMoveHistory.peek().mMovedPiece.getDisplayCharacter() + " to " + targetPos.toString());
    }

    private void updateAllLegalMoves() {
        for (ChessPiece piece : mPieceLegalMovesMap.keySet()) {
            mPieceLegalMovesMap.put(piece, piece.getAllLegalPositions());
        }
    }

    private void checkForCheck() {

    }

}
