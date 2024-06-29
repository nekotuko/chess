package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

public class Knight extends ChessPiece {
    Knight(char piece) {
        super(piece);
    }

    @Override
    public boolean[][] getAllPossiblePositions(BoardPosition pos) {
        boolean[][] legalPositions = new boolean[8][8];

        // Check all L shaped moves:
        // TODO: check if there's a way to call these as curr =
        // pos.ahead().ahead().left() etc.
        BoardPosition curr = pos.ahead().ahead().left();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.ahead().ahead().right();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.behind().behind().left();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.behind().behind().right();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.left().left().ahead();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.left().left().behind();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.right().right().ahead();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        curr = pos.right().right().behind();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        return legalPositions;
    }
}
