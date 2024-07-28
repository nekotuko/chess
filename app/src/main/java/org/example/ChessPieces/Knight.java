package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.ChessBoard;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

public class Knight extends ChessPiece {
    Knight(char piece, ChessBoard board) {
        super(piece, board);
    }

    @Override
    public List<BoardPosition> getAllLegalPositions(BoardPosition pos) {
        List<BoardPosition> legalPositions = new ArrayList<>();

        // Check all L shaped moves:
        // TODO: check if there's a way to call these as curr =
        // pos.ahead().ahead().left() etc.
        Optional<BoardPosition> movedPosition;

        // Check 2 ahead, 1 left:
        movedPosition = pos.ahead().flatMap(BoardPosition::ahead).flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 2 ahead, 1 right:
        movedPosition = pos.ahead().flatMap(BoardPosition::ahead).flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 2 behind, 1 left:
        movedPosition = pos.behind().flatMap(BoardPosition::behind).flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 2 behind, 1 right:
        movedPosition = pos.behind().flatMap(BoardPosition::behind).flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 1 ahead, 2 left:
        movedPosition = pos.ahead().flatMap(BoardPosition::left).flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 1 ahead, 2 right:
        movedPosition = pos.ahead().flatMap(BoardPosition::right).flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 1 behind, 2 left:
        movedPosition = pos.behind().flatMap(BoardPosition::left).flatMap(BoardPosition::left);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        // Check 1 behind, 2 right:
        movedPosition = pos.behind().flatMap(BoardPosition::right).flatMap(BoardPosition::right);
        if (!movedPosition.isEmpty()) {
            legalPositions.add(movedPosition.get());
        }

        return legalPositions;
    }
}
