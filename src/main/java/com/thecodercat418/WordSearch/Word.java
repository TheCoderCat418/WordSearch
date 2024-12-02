package com.thecodercat418.WordSearch;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class Word {
    String word;
    Point startPoint;
    Direction direction;
    ArrayList<Label> letters; // Used for address checking. HelloController:98
    boolean found;

    public Word(String word, Point startPoint, Direction direction, ArrayList<Label> letters){
        this.word = word;
        this.startPoint = startPoint;
        this.direction = direction;
        this.letters = letters;
    }

    public void found(){
        found = true;
    }

    public boolean isFound(){
        return found;
    }
}
