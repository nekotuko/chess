package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

public class Queen extends ChessPiece {
    Queen(char piece) {
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

        // Check all straight moves:
        curr = pos.right();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.right();
        }

        curr = pos.left();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.left();
        }

        curr = pos.ahead();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.ahead();
        }

        curr = pos.behind();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.behind();
        }

        return legalPositions;
    }
}
