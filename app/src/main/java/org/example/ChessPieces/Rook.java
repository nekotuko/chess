package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece {
    Rook(ChessBoard board, char piece) {
        super(board, piece, 5);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        // Check ahead:
        Optional<BoardPosition> movedPosition = pos.ahead();
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            ;
            movedPosition = movedPosition.get().ahead();
        }

        // Check behind:
        movedPosition = pos.behind();
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().behind();
        }

        // Check right:
        movedPosition = pos.right();
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().right();
        }

        // Check left:
        movedPosition = pos.left();
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().left();
        }

        return legalPositions;
    }
}
