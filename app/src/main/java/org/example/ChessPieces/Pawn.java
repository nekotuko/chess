package org.example.ChessPieces;

// This is the only piece, the direction of which depends on its color.
public class Pawn extends ChessPiece {

    private byte mDirection;

    Pawn(char piece) {
        this.setmDisplayCharacter(piece);
        mDirection = (piece == '♙') ? (byte) 1 : (byte) -1;
    }

    @Override
    public int[][] getLegalPositions(int[] currPos) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLegalPositions'");
    }

    @Override
    public int[][] getAllPossiblePositions(int[] currPos) {
        // Check with valid positions and return them
        return new int[][] { currPos[0] + mDirection, currPos[1] };
    }
}
