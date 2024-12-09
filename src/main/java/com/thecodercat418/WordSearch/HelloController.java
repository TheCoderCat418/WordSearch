package com.thecodercat418.WordSearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class HelloController {
    @FXML
    private AnchorPane ap;
    @FXML
    private GridPane gridPane;
    public ToggleButton addWord;
    public ToggleButton right;
    public ToggleButton left;
    public ToggleButton up;
    public ToggleButton down;
    public ToggleButton DOWN_LEFT_DIAGOINAL;
    public ToggleButton UP_LEFT_DIAGOINAL;
    public ToggleButton DOWN_RIGHT_DIAGOINAL;
    public ToggleButton UP_RIGHT_DIAGOINAL;
    public ToggleButton gro;
    public TextField a;

    private String gridSize = "25x25";
    private boolean selecting = false;
    private ArrayList<Label> labelsSelected = new ArrayList<>();
    private ArrayList<Label> completedLabels = new ArrayList<>();
    private ArrayList<Word> wordsOnGrid = new ArrayList<>();
    private boolean intercept = false;

    public Word placeWord(String word, Direction direction, Vector2D point) {

        GridSlot[][] placement = getAvailblePlacment(word, direction);
        int placementSelection = 0;
        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[i][j].status.equals(SlotStatus.FREE)) {
                    placementSelection++;
                }
            }
        }
        placementSelection = (int) Math.round(Math.random() * placementSelection) + 1; // Random word placement.

        Vector2D startingPoint = point;

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {

                if (placement[i][j].status.equals(SlotStatus.FREE) && placementSelection == 0) {
                    // startingPoint = new Point(i, j);
                }
                if (placement[i][j].status.equals(SlotStatus.FREE)) {
                    placementSelection--;
                }
            }
        }

        ArrayList<Label> letters = new ArrayList<>();

        switch (direction) {
            case RIGHT:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at " + (Integer.parseInt(gridSize.split("x")[0]) * startingPoint.x()
                                    + startingPoint.y() + i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * startingPoint.x()
                                    + startingPoint.y() + i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case LEFT:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at " + (Integer.parseInt(gridSize.split("x")[0]) * startingPoint.x()
                                    + startingPoint.y() - i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * startingPoint.x()
                                    + startingPoint.y() - i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case DOWN:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                            + startingPoint.y()));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                    + startingPoint.y()));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case UP:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                            + startingPoint.y()));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                    + startingPoint.y()));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case DOWN_LEFT_DIAGOINAL:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                            + startingPoint.y() - i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                    + startingPoint.y() - i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case DOWN_RIGHT_DIAGOINAL:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                            + startingPoint.y() + i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() + i)
                                    + startingPoint.y() + i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case UP_LEFT_DIAGOINAL:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                            + startingPoint.y() - i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                    + startingPoint.y() - i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }
                break;
            case UP_RIGHT_DIAGOINAL:
                for (int i = 0; i < word.length(); i++) {
                    System.out.println(
                            "Placing letter at "
                                    + (Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                            + startingPoint.y() + i));
                    Label l = (Label) (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (startingPoint.x() - i)
                                    + startingPoint.y() + i));
                    l.setText(String.valueOf(word.charAt(i)));
                    letters.add(l);
                }

                break;

        }
        Word returnWord = new Word(word, startingPoint, direction, letters);
        wordsOnGrid.add(returnWord);
        repairGrid();
        return returnWord;

    }

    public GridSlot[][] getAvailblePlacment(String word, Direction direction) {
        /*
         * Makes sure that the word does not go out of bounds. Later, more complicated
         * versions of this will include overlapping.
         */
        word = word.toUpperCase();
        int wordLength = word.length();

        GridSlot[][] grid = new GridSlot[Integer.parseInt(gridSize.split("x")[0])][Integer
                .parseInt(gridSize.split("x")[1])];
        for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
            for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                grid[i][j] = new GridSlot(SlotStatus.FREE);
                for (Word w : wordsOnGrid) {
                    Label l = (Label) (gridPane.getChildren().get(Integer.parseInt(gridSize.split("x")[0]) * j + i));
                    for (Label l2 : w.letters) {
                        if (l == l2) {
                            grid[i][j].status = SlotStatus.WORD;
                            grid[i][j].word = w;
                        }
                    }
                }

            }
        }
        for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
            for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                boolean zero = false;
                boolean overlap = false;
                for (int z = 0; z < wordLength; z++) {
                    switch (direction) {
                        case RIGHT:
                            if (j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get(i * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                if (grid[j + z][i].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i].word.direction.equals(Direction.RIGHT)) {
                                    overlap = true;
                                } else if (grid[j + z][i].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero) {
                                        if (grid[j + a][i].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j + a][i].status.equals(SlotStatus.FREE)) {
                                            grid[j + a][i].status = SlotStatus.CANTFIT;
                                        }

                                    } else if (overlap && wordLength + j < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].status != SlotStatus.WORD
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case LEFT:
                            if (j - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get(i * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                if (grid[j - z][i].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i].word.direction.equals(Direction.LEFT)) {
                                    overlap = true;
                                } else if (grid[j - z][i].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (j - a > -1) {
                                    if (zero) {
                                        if (grid[j - a][i].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j - a][i].status.equals(SlotStatus.FREE)) {
                                            grid[j - a][i].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap && j - wordLength > -1) {
                                        if (grid[j][i].status != SlotStatus.WORD
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case DOWN:
                            if (i + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                if (grid[j][i + z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j][i + z].word.direction.equals(Direction.DOWN)) {
                                    overlap = true;
                                } else if (grid[j][i + z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero) {
                                        if (grid[j][i + a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j][i + a].status.equals(SlotStatus.FREE)) {
                                            grid[j][i + a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap && wordLength + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].status != SlotStatus.WORD
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case UP:
                            if (i - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                if (grid[j][i - z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j][i - z].word.direction.equals(Direction.UP)) {
                                    overlap = true;
                                } else if (grid[j][i - z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1) {
                                    if (zero) {
                                        if (grid[j][i - a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j][i - a].status.equals(SlotStatus.FREE)) {
                                            grid[j][i - a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap && i - wordLength + 1 > -1) {
                                        if (grid[j][i].status != SlotStatus.WORD
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case DOWN_LEFT_DIAGOINAL:
                            if (i + z < Integer.parseInt(gridSize.split("x")[0]) && j - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                if (grid[j - z][i + z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i + z].word.direction.equals(Direction.DOWN_LEFT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (grid[j - z][i + z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0]) && j - a > -1) {
                                    if (zero) {
                                        if (grid[j - a][i + a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j - a][i + a].status.equals(SlotStatus.FREE)) {
                                            grid[j - a][i + a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap && wordLength + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].status.equals(SlotStatus.FREE)
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case DOWN_RIGHT_DIAGOINAL:
                            if (i + z < Integer.parseInt(gridSize.split("x")[0])
                                    && j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                if (grid[j + z][i + z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i + z].word.direction.equals(Direction.DOWN_RIGHT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (grid[j + z][i + z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0])
                                        && j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero) {
                                        if (grid[j + a][i + a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j + a][i + a].status.equals(SlotStatus.FREE)) {
                                            grid[j + a][i + a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap
                                            && wordLength - 1 + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].status.equals(SlotStatus.FREE)
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case UP_LEFT_DIAGOINAL:
                            if (i - z > -1 && j - z > -1) {
                                System.out.println((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                if (grid[j - z][i - z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i - z].word.direction.equals(Direction.UP_LEFT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (grid[j - z][i - z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1 && j - a > -1) {
                                    if (zero) {
                                        if (grid[j - a][i - a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j - a][i - a].status.equals(SlotStatus.FREE)) {
                                            grid[j - a][i - a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap) {
                                        if (grid[j][i].status.equals(SlotStatus.FREE)
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                        case UP_RIGHT_DIAGOINAL:
                            if (i - z > -1 && j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                if (grid[j + z][i - z].status.equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i - z].word.direction.equals(Direction.UP_RIGHT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (grid[j + z][i - z].status.equals(SlotStatus.WORD)) {
                                    zero = true;
                                }
                            } else {
                                zero = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1 && j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero) {
                                        if (grid[j + a][i - a].status.equals(SlotStatus.WORD)) {
                                            break;
                                        }
                                        if (grid[j + a][i - a].status.equals(SlotStatus.FREE)) {
                                            grid[j + a][i - a].status = SlotStatus.CANTFIT;
                                        }
                                    } else if (overlap) {
                                        if (grid[j][i].status.equals(SlotStatus.FREE)
                                                || (grid[j][i].status.equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].status = SlotStatus.OVERLAP;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }

        return grid;
    }

    public void repairGrid() {
        boolean rescan = false;
        do {
            rescan = false;
            for (Word word : wordsOnGrid) {
                GridSlot[][] map = getAvailblePlacment(word.word, Direction.RIGHT);
                for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
                    for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                        if(map[j][i].status.equals(SlotStatus.WORD)){
                            continue;
                        }
                        for (Direction d : Direction.values()) {
                            String selectedWord = "";
                            for (int z = 0; z < word.word.length(); z++) {
                                Label l = null;
                                switch (d) {
                                    case RIGHT:
                                        if (j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get(i * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                        }
                                        break;
                                    case LEFT:
                                        if (j - z > -1) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get(i * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                        }
                                        break;
                                    case DOWN:
                                        if (i + z < Integer.parseInt(gridSize.split("x")[0])) {

                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                        }
                                        break;
                                    case UP:
                                        if (i - z > -1) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                        }
                                        break;
                                    case DOWN_LEFT_DIAGOINAL:
                                        if (i + z < Integer.parseInt(gridSize.split("x")[0]) && j - z > -1) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                        }
                                        break;
                                    case DOWN_RIGHT_DIAGOINAL:
                                        if (i + z < Integer.parseInt(gridSize.split("x")[0])
                                                && j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                        }
                                        break;
                                    case UP_LEFT_DIAGOINAL:
                                        if (i - z > -1 && j - z > -1) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                        }
                                        break;
                                    case UP_RIGHT_DIAGOINAL:
                                        if (i - z > -1 && j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                            l = (Label) gridPane.getChildrenUnmodifiable()
                                                    .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                        }
                                        break;

                                }
                                if(l == null){continue;}
                                    selectedWord += l.getText();
                             
                                
                                if(word.word.equals(selectedWord)){
                                    System.out.println("Unwanted copy of " + word.word + " found!");
                                    rescan = true;
                                    for (int fix = 0; fix < word.word.length(); fix++) {
                                        switch (word.direction) {
                                            case RIGHT:
                                                    l = (Label)gridPane.getChildren()
                                                            .get(i * Integer.parseInt(gridSize.split("x")[0]) + j + fix);

                                                break;
                                            case LEFT:
                                                    l = (Label) gridPane.getChildren()
                                                            .get(i * Integer.parseInt(gridSize.split("x")[0]) + j - fix);
                                                
                                                break;
                                            case DOWN:
        
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i + fix) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                                
                                                break;
                                            case UP:
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i - fix) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                                
                                                break;
                                            case DOWN_LEFT_DIAGOINAL:
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i + fix) * Integer.parseInt(gridSize.split("x")[0]) + j - fix);
                                                
                                                break;
                                            case DOWN_RIGHT_DIAGOINAL:
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i + fix) * Integer.parseInt(gridSize.split("x")[0]) + j + fix);
                                                
                                                break;
                                            case UP_LEFT_DIAGOINAL:
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i - fix) * Integer.parseInt(gridSize.split("x")[0]) + j - fix);
                                                
                                                break;
                                            case UP_RIGHT_DIAGOINAL:
                                                    l = (Label) gridPane.getChildren()
                                                            .get((i - fix) * Integer.parseInt(gridSize.split("x")[0]) + j + fix);
                                                
                                                break;
                                            default:
                                                l = null;
                                                break;
        
                                        }
                                        l.setText(String.valueOf(Character.toChars((int) (Math.random() * 26) + 65)));

                                    }
                                }

                            }
                        }
                    }
                }
            }

        } while (rescan);
    }

    public boolean wordCompleteion() { // Checks to see if a word is completed.
        for (int i = 0; i < wordsOnGrid.size(); i++) {
            int numCorrect = 0;
            for (int z = 0; z < wordsOnGrid.get(i).letters.size(); z++) {
                for (int j = 0; j < labelsSelected.size(); j++) {
                    if (wordsOnGrid.get(i).letters.get(z) == labelsSelected.get(j)) {
                        numCorrect++;
                    }
                }
            }
            if (numCorrect == wordsOnGrid.get(i).word.length() && !wordsOnGrid.get(i).found) { /*
                                                                                                * If they all are, make
                                                                                                * them green and add
                                                                                                * them to
                                                                                                * the protected
                                                                                                * ArrayList.
                                                                                                */
                for (int l = 0; l < labelsSelected.size(); l++) {
                    labelsSelected.get(l).setStyle("-fx-background-color: green");
                    completedLabels.add(labelsSelected.get(l));
                }
                wordsOnGrid.get(i).found = true;
                labelsSelected.clear(); // Reset selection
                selecting = false;
                return true;
            }
        }
        return false;

    }

    public void onLetterClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().compareTo(MouseButton.SECONDARY) == 0) {
            /* If right mouse button is clicked, reset selection. */
            for (int i = 0; i < labelsSelected.size(); i++) {
                labelsSelected.get(i).setStyle("");
                for (Word w : wordsOnGrid) {
                    for (Label l : w.letters) {
                        if (w.found && l == labelsSelected.get(i)) {
                            labelsSelected.get(i).setStyle("-fx-background-color: green");
                        }
                    }
                }

            }

            labelsSelected.clear();
            selecting = false;
            return;
        }

        Label label = (Label) mouseEvent.getSource();

        for (Label l : labelsSelected) { // Validate to make sure we don't add any duplicate Labels.
            if (l == label) {
                return;
            }
        }

        if (selecting == true) {
            for (int i = -1; i < 2; i++) { /*
                                            * Makes sure that the selection is a "line". Does not check if it's straight
                                            * line, only if there is a yellow next to it.
                                            */
                for (int j = -1; j < 2; j++) { // Checks one grid out from the clicked Label
                    if (Integer.parseInt(gridSize.split("x")[0]) * (GridPane.getRowIndex(label) + i)
                            + GridPane.getColumnIndex(label) + j < -1
                            || Integer.parseInt(gridSize.split("x")[0]) * (GridPane.getRowIndex(label) + i)
                                    + GridPane.getColumnIndex(label) + j > Integer.parseInt(gridSize.split("x")[0])
                                            * Integer.parseInt(gridSize.split("x")[0])) {
                        continue;
                    }
                    if (gridPane.getChildren()
                            .get(Integer.parseInt(gridSize.split("x")[0]) * (GridPane.getRowIndex(label) + i)
                                    + GridPane.getColumnIndex(label) + j)
                            .getStyle().equals("-fx-background-color: yellow")) {
                        label.setStyle("-fx-background-color: yellow");
                        labelsSelected.add(label);
                        break;
                    }
                }
            }
        } else { // No yellow points to check to. Skip checking
            label.setStyle("-fx-background-color: yellow");
            labelsSelected.add(label);
            selecting = true; // Will check the next one
        }

        wordCompleteion();

    }

    public void onMouseHover(MouseEvent actionEvent, boolean entering) {
        Label label = (Label) actionEvent.getSource();

        for (Label l : labelsSelected) { // Do not change color, has priority/protection
            if (l == label) {
                return;
            }
        }
        for (Label l : completedLabels) {// Do not change color, has priority/protection
            if (l == label) {
                return;
            }
        }
        if (entering) {
            label.setStyle("-fx-background-color: gray");
        } else {
            label.setStyle("");
        }
    }

    public void initialize() {
        gridPane.getChildren().clear();

        for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
            gridPane.getColumnConstraints()
                    .add(new ColumnConstraints(gridPane.getPrefWidth() / Integer.parseInt(gridSize.split("x")[0])));
            /* Evenly divide the grid to fit PERFECLY. */

            for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                gridPane.getRowConstraints()
                        .add(new RowConstraints(gridPane.getPrefHeight() / Integer.parseInt(gridSize.split("x")[1])));

                Label l = new Label(String.valueOf(Character.toChars((int) (Math.random() * 26) + 65))); //26
                /* Random letters. */

                l.setPrefWidth(gridPane.getPrefWidth() / Integer.parseInt(gridSize.split("x")[0]));
                l.setPrefHeight(gridPane.getPrefHeight() / Integer.parseInt(gridSize.split("x")[1]));

                l.setFont(Font.font((gridPane.getPrefWidth() / Integer.parseInt(gridSize.split("x")[0])) * 0.77));
                /* Magic spacing number. */

                l.setAlignment(Pos.CENTER);

                l.setOnMouseEntered(actionEvent -> {
                    if (intercept) {
                        INTERCEPTER("LetterEntered", actionEvent);
                    } else {
                        onMouseHover(actionEvent, true);
                    }
                });
                l.setOnMouseExited(actionEvent -> {
                    if (intercept) {
                        INTERCEPTER("LetterExited", actionEvent);
                    } else {
                        onMouseHover(actionEvent, false);
                    }
                });
                l.setOnMouseClicked(actionEvent -> {
                    if (intercept) {
                        INTERCEPTER("LetterClicked", actionEvent);
                    } else {
                        onLetterClicked(actionEvent);
                    }
                });

                gridPane.add(l, j, i);
            }
        }

        // placeWord("NANA", Direction.RIGHT);
        // placeWord("GREG", Direction.RIGHT);
        // placeWord("ERIN", Direction.RIGHT);
        // placeWord("CORA", Direction.RIGHT);
        // placeWord("ELLIOTT", Direction.RIGHT);
    }

    // DEBUG TOOLS

    Vector2D lastClicked = new Vector2D(0, 0);

    public void INTERCEPTER(String what, Object thing) {
        switch (what) {
            case "LetterClicked": // Label that was clicked
                MouseEvent me = (MouseEvent) thing;
                Label label = (Label) me.getSource();
                lastClicked = new Vector2D(GridPane.getRowIndex(label), GridPane.getColumnIndex(label));
                break;
            case "LetterExited":
                break;
            case "LetterEntered":
                break;
        }
    }

    public void addWord() {

        Direction direction = Direction.RIGHT;
        if (right.isSelected()) {
            direction = Direction.RIGHT;
        } else if (left.isSelected()) {
            direction = Direction.LEFT;
        } else if (up.isSelected()) {
            direction = Direction.UP;
        } else if (down.isSelected()) {
            direction = Direction.DOWN;
        } else if (UP_LEFT_DIAGOINAL.isSelected()) {
            direction = Direction.UP_LEFT_DIAGOINAL;
        } else if (UP_RIGHT_DIAGOINAL.isSelected()) {
            direction = Direction.UP_RIGHT_DIAGOINAL;
        } else if (DOWN_LEFT_DIAGOINAL.isSelected()) {
            direction = Direction.DOWN_LEFT_DIAGOINAL;
        } else if (DOWN_RIGHT_DIAGOINAL.isSelected()) {
            direction = Direction.DOWN_RIGHT_DIAGOINAL;
        }

        GridSlot[][] placement = getAvailblePlacment(a.getText(), direction);

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                Label l = (Label) gridPane.getChildren().get(i * 25 + j);
                switch (placement[j][i].status) {
                    case CANTFIT:
                        l.setStyle("-fx-background-color: blue");
                        break;
                    case WORD:
                        l.setStyle("-fx-background-color: red");
                        break;
                    case FREE:
                        l.setStyle("-fx-background-color: green");
                        break;
                    case OVERLAP:
                        l.setStyle("-fx-background-color: yellow");
                        break;

                }

            }

        }

        if (!addWord.isSelected()) {
            placeWord(a.getText(), direction, lastClicked);
            for (int i = 0; i < placement.length; i++) {
                for (int j = 0; j < placement[i].length; j++) {
                    Label l = (Label) gridPane.getChildren().get(i * 25 + j);
                    l.setStyle("");

                }
            }
        }

    }

    public void toggleInterceptGRO() {
        if (intercept) {
            intercept = false;
        } else {
            intercept = true;
        }
    }

}