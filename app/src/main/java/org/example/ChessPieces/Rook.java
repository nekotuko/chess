package org.example.ChessPieces;

import org.example.BoardPosition;

public class Rook extends ChessPiece {
    Rook(char piece) {
        this.setmDisplayCharacter(piece);
    }

    @Override
    public BoardPosition[] getLegalPositions(BoardPosition pos) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLegalPositions'");
    }
}
