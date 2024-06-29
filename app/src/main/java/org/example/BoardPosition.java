package org.example;

public class BoardPosition {
    public final int i;
    public final int j;

    private BoardPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Singleton class to represent an invalid position. Useful for chaining moves:
    public static class InvalidBoardPosition extends BoardPosition {
        private static final InvalidBoardPosition mInstance = new InvalidBoardPosition();

        private InvalidBoardPosition() {
            super(-1, -1);
        }

        public static InvalidBoardPosition getInstance() {
            return mInstance;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public BoardPosition right() {
            return this;
        }

        @Override
        public BoardPosition left() {
            return this;
        }

        @Override
        public BoardPosition ahead() {
            return this;
        }

        @Override
        public BoardPosition behind() {
            return this;
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }
    }

    public static BoardPosition fromCoords(int i, int j) {
        if (isValid(i, j)) {
            return new BoardPosition(i, j);
        } else {
            return InvalidBoardPosition.getInstance();
        }

    }

    public boolean isValid() {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public BoardPosition right() {
        if (isValid(this.i, this.j + 1)) {
            return new BoardPosition(this.i, this.j + 1);
        } else {
            return InvalidBoardPosition.getInstance();
        }
    }

    public BoardPosition left() {
        if (isValid(this.i, this.j - 1)) {
            return new BoardPosition(this.i, this.j - 1);
        } else {
            return InvalidBoardPosition.getInstance();
        }
    }

    public BoardPosition ahead() {
        if (isValid(this.i + 1, this.j)) {
            return new BoardPosition(this.i + 1, this.j);
        } else {
            return InvalidBoardPosition.getInstance();
        }
    }

    public BoardPosition behind() {
        if (isValid(this.i - 1, this.j)) {
            return new BoardPosition(this.i - 1, this.j);
        } else {
            return InvalidBoardPosition.getInstance();
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
