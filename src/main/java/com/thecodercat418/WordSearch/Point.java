package com.thecodercat418.WordSearch;

public class Point { // Record? Simple storage point class.
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + this.x + " Y:" + this.y;
    }
}
