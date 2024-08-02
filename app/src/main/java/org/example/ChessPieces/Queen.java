package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

public class Queen extends ChessPiece {
    Queen(ChessBoard board, char piece) {
        super(board, piece, 9);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        // Check all diagonal moves:
        Optional<BoardPosition> movedPosition;

        // Check ahead, left:
        movedPosition = pos.ahead().flatMap(BoardPosition::left);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().ahead().flatMap(BoardPosition::left);
        }

        // Check ahead, right:
        movedPosition = pos.ahead().flatMap(BoardPosition::right);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().ahead().flatMap(BoardPosition::right);
        }

        // Check behind, left:
        movedPosition = pos.behind().flatMap(BoardPosition::left);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().behind().flatMap(BoardPosition::left);
        }

        // Check behind, right:
        movedPosition = pos.behind().flatMap(BoardPosition::right);
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
            movedPosition = movedPosition.get().behind().flatMap(BoardPosition::right);
        }

        // Check all straight moves:

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

        // Check ahead:
        movedPosition = pos.ahead();
        while (!movedPosition.isEmpty()) {
            if (mBoard.positionIsOccupied(movedPosition.get())) {
                if (this.canTake(mBoard.getPieceFromPos(movedPosition.get()))) {
                    legalPositions.add(movedPosition.get());
                }
                break;
            }
            legalPositions.add(movedPosition.get());
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

        return legalPositions;
    }
}
