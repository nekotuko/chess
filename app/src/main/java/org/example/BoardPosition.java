package org.example;

import java.util.Optional;

public class BoardPosition {
    public final int i;
    public final int j;

    private BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // A public factory method to create a BoardPosition object from given coordinates:
    public static BoardPosition fromCoords(int i, int j) {
        // Only create a BoardPosition object if the coordinates are within the 8x8 board:
        if (i >= 0 && i < 8 && j >= 0 && j < 8) {
            return new BoardPosition(i, j);
        } else {
            return null;
        }
    }

    // Private method to create an optional wrapped BoardPosition object:
    private static Optional<BoardPosition> moveTo(int i, int j) {
        BoardPosition targetPos = BoardPosition.fromCoords(i, j);
        if (targetPos != null) {
            return Optional.of(new BoardPosition(i, j));
        } else {
            return Optional.empty();
        }
    }

    public Optional<BoardPosition> right() {
        return moveTo(this.i, this.j + 1);
    }

    public Optional<BoardPosition> left() {
        return moveTo(this.i, this.j - 1);
    }

    public Optional<BoardPosition> ahead() {
        return moveTo(this.i + 1, this.j);
    }

    public Optional<BoardPosition> behind() {
        return moveTo(this.i - 1, this.j);
    }

    // Overriden method to compare if two BoardPosition objects are equal:
    @Override
    public boolean equals(Object obj) {
        // Check if the argument is a reference to the object itself
        if (this == obj) {
            return true;
        }
        // Check if the argument is not of the type 'BoardPosition'
        if (!(obj instanceof BoardPosition)) {
            return false;
        }
        // Cast the argument to 'BoardPosition' type, then compare the fields
        BoardPosition pos = (BoardPosition) obj;
        return this.i == pos.i && this.j == pos.j;
    }
}
