package org.example;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;

public class BoardPosition {
    public final int i;
    public final int j;

    private BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static BoardPosition fromCoords(int i, int j) {
        if (isValid(i, j)) {
            return new BoardPosition(i, j);
        } else {
            // TODO: Check the proper exception type for this:
            throw new UnsupportedOperationException("Attempted to init an invalid position.");
        }

    }

    public boolean isValid() {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public static BoardPosition rightOf(BoardPosition pos) {
        if (BoardPosition.isValid(pos.i, pos.j + 1)) {
            return new BoardPosition(pos.i, pos.j + 1);
        } else {
            return null;
        }
    }

    public static BoardPosition leftOf(BoardPosition pos) {
        if (BoardPosition.isValid(pos.i, pos.j - 1)) {
            return new BoardPosition(pos.i, pos.j - 1);
        } else {
            return null;
        }
    }

    public static BoardPosition upOf(BoardPosition pos) {
        if (BoardPosition.isValid(pos.i + 1, pos.j)) {
            return new BoardPosition(pos.i + 1, pos.j);
        } else {
            return null;
        }
    }

    public static BoardPosition downOf(BoardPosition pos) {
        if (BoardPosition.isValid(pos.i - 1, pos.j)) {
            return new BoardPosition(pos.i - 1, pos.j);
        } else {
            return null;
        }
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
