package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

public class Rook extends ChessPiece {
    Rook(char piece) {
        super(piece);
    }

    @Override
    public boolean[][] getAllPossiblePositions(BoardPosition pos) {
        boolean[][] legalPositions = new boolean[8][8];

        // Check right:
        BoardPosition curr = pos.right();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.right();
        }

        // Check left:
        curr = pos.left();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.left();
        }

        // Check ahead:
        curr = pos.ahead();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.ahead();
        }

        // Check behind:
        curr = pos.behind();
        while (!(curr instanceof InvalidBoardPosition)) {
            legalPositions[curr.i][curr.j] = true;
            curr = curr.behind();
        }

        return legalPositions;
    }
}
