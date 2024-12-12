package com.thecodercat418.WordSearch;

import java.util.ArrayList;

import javafx.scene.control.Label;
public class Word {
    private String word;
    private Vector2D startPoint;
    private Direction direction;
    private ArrayList<Label> letters; // Used for address checking. HelloController:98
    private boolean found;

    public Word(String word, Vector2D startPoint, Direction direction, ArrayList<Label> letters){
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Vector2D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Vector2D startPoint) {
        this.startPoint = startPoint;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ArrayList<Label> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Label> letters) {
        this.letters = letters;
    }

    
}
