package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece {
    Bishop(ChessBoard board, char piece) {
        super(board, piece, 3);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        // Check all diagonal moves:
        Optional<BoardPosition> movedPosition;

        movedPosition = pos.ahead().flatMap(BoardPosition::right);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.flatMap(BoardPosition::ahead).flatMap(BoardPosition::right);
        }

        movedPosition = pos.ahead().flatMap(BoardPosition::left);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.flatMap(BoardPosition::ahead).flatMap(BoardPosition::left);
        }

        movedPosition = pos.behind().flatMap(BoardPosition::right);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.flatMap(BoardPosition::behind).flatMap(BoardPosition::right);
        }

        movedPosition = pos.behind().flatMap(BoardPosition::left);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.flatMap(BoardPosition::behind).flatMap(BoardPosition::left);
        }

        return legalPositions;

    }

}
