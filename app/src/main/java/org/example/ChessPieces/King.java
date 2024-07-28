package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

public class King extends ChessPiece {
    King(char piece, ChessBoard board) {
        super(piece, board);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        Optional<BoardPosition> movedPosition;

        // Check right:
        movedPosition = pos.right();
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check left:
        movedPosition = pos.left();
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check ahead:
        movedPosition = pos.ahead();
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check behind:
        movedPosition = pos.behind();
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check ahead-right:
        movedPosition = pos.ahead().flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check ahead-left:
        movedPosition = pos.ahead().flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check behind-right:
        movedPosition = pos.behind().flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check behind-left:
        movedPosition = pos.behind().flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        return legalPositions;
    }
}
