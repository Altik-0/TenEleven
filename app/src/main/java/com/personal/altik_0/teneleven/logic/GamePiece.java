package com.personal.altik_0.teneleven.logic;

/**
 * Created by Altik_0 on 3/25/2015.
 */
public abstract class GamePiece {

    protected boolean[][] pieceGrid;

    public boolean getEntry(int x, int y) {
        return pieceGrid[x][y];
    }

    public int getWidth() {
        return pieceGrid.length;
    }

    public int getHeight() {
        return pieceGrid[0].length;
    }

    public int getScore() {
        int cntr = 0;
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                cntr += pieceGrid[x][y] ? 1 : 0;

        return cntr;
    }

    /**
     * Rotates this piece's grid clockwise the specified number of times
     * @param cycles
     */
    public void rotatePiece(int cycles) {
        cycles %= 4;
        for (; cycles > 0; cycles--) {
            boolean[][] newGrid = new boolean[getHeight()][getWidth()];

            for (int x = 0; x < getWidth(); x++)
                for (int y = 0; y < getHeight(); y++)
                    newGrid[y][getWidth()-1-x] = pieceGrid[x][y];

            pieceGrid = newGrid;
        }
    }
}
