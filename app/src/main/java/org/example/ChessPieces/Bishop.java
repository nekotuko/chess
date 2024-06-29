package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

public class Bishop extends ChessPiece {
    Bishop(char piece) {
        super(piece);
    }

    @Override
    public boolean[][] getAllPossiblePositions(BoardPosition pos) {
        boolean[][] legalPositions = new boolean[8][8];

        // Check all diagonal moves:
        BoardPosition curr = pos.ahead().left();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.ahead().left();
        }

        curr = pos.ahead().right();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.ahead().right();
        }

        curr = pos.behind().left();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.behind().left();
        }

        curr = pos.behind().right();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.behind().right();
        }

        return legalPositions;

    }

}
