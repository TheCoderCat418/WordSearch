package com.thecodercat418.WordSearch;

public class Word {
    String word;
    Point startPoint;
    Direction direction;

    public Word(String word, Point startPoint, Direction direction){
        this.word = word;
        this.startPoint = startPoint;
        this.direction = direction;
    }
}
