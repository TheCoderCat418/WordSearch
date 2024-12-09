package com.thecodercat418.WordSearch;

public class Vector2D { // Record? Simple storage point class.
    public int x;
    public int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + this.x + " Y:" + this.y;
    }
}
