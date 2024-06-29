package org.example.ChessPieces;

import org.example.BoardPosition;
import org.example.BoardPosition.InvalidBoardPosition;

// This is the only piece, the direction of which depends on its color.
public class Pawn extends ChessPiece {

    Pawn(char piece) {
        super(piece);
    }

    @Override
    public boolean[][] getAllPossiblePositions(BoardPosition pos) {
        boolean[][] legalPositions = new boolean[8][8];

        // Check ahead if is white. Check if can move two steps ahead:
        if (this.isWhite()) {
            BoardPosition curr = pos.ahead();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }

            if (pos.i == 1) {
                curr = pos.ahead().ahead();
                if (!(curr instanceof InvalidBoardPosition)) {
                    legalPositions[curr.i][curr.j] = true;
                }
            }

            // Check if can take another piece. Whether there's a piece there will be
            // checked by the ChessBoard class.:
            curr = pos.ahead().left();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }
            curr = pos.ahead().right();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }
        }

        // Check behind if is black
        if (!this.isWhite()) {
            BoardPosition curr = pos.behind();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }

            // Check if can move two steps behind:
            if (pos.i == 6) {
                curr = pos.behind().behind();
                if (!(curr instanceof InvalidBoardPosition)) {
                    legalPositions[curr.i][curr.j] = true;
                }
            }

            // Check if can take another piece. Whether there's a piece there will be
            // checked by the ChessBoard class.:
            curr = pos.behind().left();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }
            curr = pos.behind().right();
            if (!(curr instanceof InvalidBoardPosition)) {
                legalPositions[curr.i][curr.j] = true;
            }
        }

        return legalPositions;
    }
}
