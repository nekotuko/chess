package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

public class King extends ChessPiece {
    King(char piece) {
        super(piece);
    }

    @Override
    public boolean[][] getAllPossiblePositions(BoardPosition pos) {
        boolean[][] legalPositions = new boolean[8][8];

        // Check right:
        BoardPosition curr = pos.right();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check left:
        curr = pos.left();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check ahead:
        curr = pos.ahead();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check behind:
        curr = pos.behind();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check ahead-right:
        curr = pos.ahead().right();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check ahead-left:
        curr = pos.ahead().left();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check behind-right:
        curr = pos.behind().right();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        // Check behind-left:
        curr = pos.behind().left();
        if (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
        }

        return legalPositions;
    }
}
