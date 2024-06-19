package org.example.ChessPieces;

public class Rook extends ChessPiece {
    Rook(char piece) {
        this.setmDisplayCharacter(piece);
    }

    @Override
    public int[][] getLegalPositions(int[] currPos) {
        int[][] legalPositions = new int[16][2];
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLegalPositions'");
    }

    @Override
    public int[][] getAllPossiblePositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPossiblePositions'");
    }
}
