package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

// This is the only piece, the direction of which depends on its color.
public class Pawn extends ChessPiece {

    Pawn(ChessBoard board, char piece) {
        super(board, piece, 1);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        Optional<BoardPosition> movedPosition;
        if (this.isWhite()) {
            // Check ahead if is white:
            movedPosition = pos.ahead();
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }

            // Check for two moves ahead from starting position:
            if (pos.i == 1) {
                movedPosition = movedPosition.get().ahead();
                if (!movedPosition.isEmpty()) {
                    legalPositions.add(movedPosition.get());
                }
            }

            // Check for take moves:
            movedPosition = pos.ahead().flatMap(BoardPosition::left);
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }

            movedPosition = pos.ahead().flatMap(BoardPosition::right);
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }
        } else {
            // Check behind if is black:
            movedPosition = pos.behind();
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }

            // Check for two moves behind from starting position:
            if (pos.i == 6) {
                movedPosition = movedPosition.get().behind();
                if (!movedPosition.isEmpty()) {
                    legalPositions.add(movedPosition.get());
                }
            }

            // Check for take moves:
            movedPosition = pos.behind().flatMap(BoardPosition::left);
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }

            movedPosition = pos.behind().flatMap(BoardPosition::right);
            if (!movedPosition.isEmpty()) {
                legalPositions.add(movedPosition.get());
            }
        }

        return legalPositions;
    }
}
