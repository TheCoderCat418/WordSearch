package com.thecodercat418.WordSearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    public ListView<String> userWordList;
    public Label title;

    private String gridSize = "20x20";
    private boolean selecting = false;
    private ArrayList<Label> labelsSelected = new ArrayList<>();
    private ArrayList<Label> completedLabels = new ArrayList<>();
    private ArrayList<Word> wordsOnGrid = new ArrayList<>();
    private boolean intercept = false;

    public Word placeWord(String word, Direction direction) {

        GridSlot[][] placement = getAvailblePlacment(word, direction);
        ArrayList<GridSlot> gss = new ArrayList<>();
        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[j][i].getStatus().equals(SlotStatus.FREE)
                        || placement[j][i].getStatus().equals(SlotStatus.OVERLAP)) {
                    gss.add(placement[j][i]);
                }
            }
        }
        ArrayList<GridSlot> gaa = new ArrayList<>();

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[j][i].getStatus().equals(SlotStatus.OVERLAP)) {
                    gaa.add(placement[j][i]);
                }
            }
        }
        GridSlot placementSelection;
        placementSelection = gss.get((int) (Math.random() * gss.size())); // Random word placement.

        Vector2D startingPoint = null;
        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[j][i] == placementSelection) {
                    startingPoint = new Vector2D(i, j);
                }
            }
        }

        ArrayList<Label> letters = new ArrayList<>();

        // for (int i = 0; i < placement.length; i++) {
        // for (int j = 0; j < placement[i].length; j++) {
        // //Label l = (Label) gridPane.getChildren().get(i * 25 + j);
        // // l.setStyle("");
        // System.out.println(placement[j][i].getStatus());
        // switch (placement[j][i].getStatus()) {
        // case CANTFIT:
        // // l.setStyle("-fx-background-color: blue");
        // break;
        // case WORD:
        // // l.setStyle("-fx-background-color: red");
        // break;
        // case FREE:
        // // l.setStyle("-fx-background-color: green");
        // break;
        // case OVERLAP:
        // // l.setStyle("-fx-background-color: yellow");
        // break;

        // }

        // }
        // }

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
        userWordList.getItems().add(returnWord.getWord());
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
                    for (Label l2 : w.getLetters()) {
                        if (l == l2) {
                            grid[i][j].setStatus(SlotStatus.WORD);
                            grid[i][j].setWord(w);
                        }
                    }
                }

            }
        }
        for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
            for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                boolean zero = false;
                boolean overlap = false;
                boolean border = false;
                for (int z = 0; z < wordLength; z++) {
                    switch (direction) {
                        case RIGHT:
                            if (j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get(i * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                if (grid[j + z][i].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i].getWord().getDirection().equals(Direction.RIGHT)
                                        && !grid[j + z][i].getWord().getDirection().equals(Direction.LEFT)) {
                                    overlap = true;
                                } else if (!grid[j + z][i].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero || border) {
                                        if (!grid[j + a][i].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j + a][i].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j + a][i].setStatus(SlotStatus.CANTFIT);
                                        }

                                    } else if (overlap && wordLength + j < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].getStatus() != SlotStatus.WORD
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
                                        }
                                    }
                                }
                            }
                            break;
                        case LEFT:
                            if (j - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get(i * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                if (grid[j - z][i].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i].getWord().getDirection().equals(Direction.RIGHT)
                                        && !grid[j - z][i].getWord().getDirection().equals(Direction.LEFT)) {
                                    overlap = true;
                                } else if (!grid[j - z][i].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (j - a > -1) {
                                    if (zero || border) {
                                        if (!grid[j - a][i].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j - a][i].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j - a][i].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap && j - wordLength > -1) {
                                        if (grid[j][i].getStatus() != SlotStatus.WORD
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
                                        }
                                    }
                                }
                            }
                            break;
                        case DOWN:
                            if (i + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                if (grid[j][i + z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j][i + z].getWord().getDirection().equals(Direction.DOWN)
                                        && !grid[j][i + z].getWord().getDirection().equals(Direction.UP)) {
                                    overlap = true;
                                } else if (!grid[j][i + z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero || border) {
                                        if (!grid[j][i + a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j][i + a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j][i + a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap && wordLength + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].getStatus() != SlotStatus.WORD
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
                                        }
                                    }
                                }
                            }
                            break;
                        case UP:
                            if (i - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j);
                                if (grid[j][i - z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j][i - z].getWord().getDirection().equals(Direction.DOWN)
                                        && !grid[j][i - z].getWord().getDirection().equals(Direction.UP)) {
                                    overlap = true;
                                } else if (!grid[j][i - z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1) {
                                    if (zero || border) {
                                        if (!grid[j][i - a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j][i - a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j][i - a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap && i - wordLength + 1 > -1) {
                                        if (grid[j][i].getStatus() != SlotStatus.WORD
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
                                        }
                                    }
                                }
                            }
                            break;
                        case DOWN_LEFT_DIAGOINAL:
                            if (i + z < Integer.parseInt(gridSize.split("x")[0]) && j - z > -1) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i + z) * Integer.parseInt(gridSize.split("x")[0]) + j - z);
                                if (grid[j - z][i + z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i + z].getWord().getDirection()
                                                .equals(Direction.DOWN_LEFT_DIAGOINAL)
                                        && !grid[j - z][i + z].getWord().getDirection()
                                                .equals(Direction.UP_RIGHT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (!grid[j - z][i + z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0]) && j - a > -1) {
                                    if (zero || border) {
                                        if (!grid[j - a][i + a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j - a][i + a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j - a][i + a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap && wordLength + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].getStatus().equals(SlotStatus.FREE)
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
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
                                if (grid[j + z][i + z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i + z].getWord().getDirection()
                                                .equals(Direction.DOWN_RIGHT_DIAGOINAL)
                                        && !grid[j + z][i + z].getWord().getDirection()
                                                .equals(Direction.UP_LEFT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (!grid[j + z][i + z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i + a < Integer.parseInt(gridSize.split("x")[0])
                                        && j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero || border) {
                                        if (!grid[j + a][i + a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j + a][i + a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j + a][i + a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap
                                            && wordLength - 1 + i < Integer.parseInt(gridSize.split("x")[0])) {
                                        if (grid[j][i].getStatus().equals(SlotStatus.FREE)
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
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
                                if (grid[j - z][i - z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j - z][i - z].getWord().getDirection()
                                                .equals(Direction.DOWN_RIGHT_DIAGOINAL)
                                        && !grid[j - z][i - z].getWord().getDirection()
                                                .equals(Direction.UP_LEFT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (!grid[j - z][i - z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1 && j - a > -1) {
                                    if (zero || border) {
                                        if (!grid[j - a][i - a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j - a][i - a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j - a][i - a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap) {
                                        if (grid[j][i].getStatus().equals(SlotStatus.FREE)
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
                                        }
                                    }
                                }
                            }
                            break;
                        case UP_RIGHT_DIAGOINAL:
                            if (i - z > -1 && j + z < Integer.parseInt(gridSize.split("x")[0])) {
                                Label l = (Label) gridPane.getChildrenUnmodifiable()
                                        .get((i - z) * Integer.parseInt(gridSize.split("x")[0]) + j + z);
                                if (grid[j + z][i - z].getStatus().equals(SlotStatus.WORD)
                                        && l.getText().equals(word.substring(z, z + 1))
                                        && !grid[j + z][i - z].getWord().getDirection()
                                                .equals(Direction.DOWN_LEFT_DIAGOINAL)
                                        && !grid[j + z][i - z].getWord().getDirection()
                                                .equals(Direction.UP_RIGHT_DIAGOINAL)) {
                                    overlap = true;
                                } else if (!grid[j + z][i - z].getWord().getWord().isEmpty()) {
                                    zero = true;
                                }
                            } else {
                                border = true;
                            }

                            for (int a = 0; a < wordLength; a++) {
                                if (i - a > -1 && j + a < Integer.parseInt(gridSize.split("x")[0])) {
                                    if (zero || border) {
                                        if (!grid[j + a][i - a].getWord().getWord().isEmpty() && !border) {
                                            break;
                                        }
                                        if (grid[j + a][i - a].getStatus().equals(SlotStatus.FREE)) {
                                            grid[j + a][i - a].setStatus(SlotStatus.CANTFIT);
                                        }
                                    } else if (overlap) {
                                        if (grid[j][i].getStatus().equals(SlotStatus.FREE)
                                                || (grid[j][i].getStatus().equals(SlotStatus.WORD) && a == 0)) {
                                            grid[j][i].setStatus(SlotStatus.OVERLAP);
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
                for (int i = 0; i < Integer.parseInt(gridSize.split("x")[0]); i++) {
                    for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                        for (Direction d : Direction.values()) {
                            String selectedWord = "";
                            for (int z = 0; z < word.getWord().length(); z++) {
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
                                if (l == null) {
                                    continue;
                                }
                                boolean exists = false;
                                for (Word word3 : wordsOnGrid) {
                                    for (Label l2 : word3.getLetters()) {
                                        if (l == l2) {
                                            exists = true;
                                        }
                                    }
                                }
                                if (!exists) {
                                    selectedWord += l.getText();
                                }

                                if (word.getWord().equals(selectedWord)) {
                                    System.out.println("Unwanted copy of " + word.getWord() + " found!");
                                    rescan = true;
                                    for (int fix = 0; fix < word.getWord().length(); fix++) {
                                        switch (word.getDirection()) {
                                            case RIGHT:
                                                l = (Label) gridPane.getChildren()
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
                                                        .get((i + fix) * Integer.parseInt(gridSize.split("x")[0]) + j
                                                                - fix);

                                                break;
                                            case DOWN_RIGHT_DIAGOINAL:
                                                l = (Label) gridPane.getChildren()
                                                        .get((i + fix) * Integer.parseInt(gridSize.split("x")[0]) + j
                                                                + fix);

                                                break;
                                            case UP_LEFT_DIAGOINAL:
                                                l = (Label) gridPane.getChildren()
                                                        .get((i - fix) * Integer.parseInt(gridSize.split("x")[0]) + j
                                                                - fix);

                                                break;
                                            case UP_RIGHT_DIAGOINAL:
                                                l = (Label) gridPane.getChildren()
                                                        .get((i - fix) * Integer.parseInt(gridSize.split("x")[0]) + j
                                                                + fix);

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
            for (Label l : wordsOnGrid.get(i).getLetters()) {
                for (Label l2 : labelsSelected) {
                    if (l == l2) {
                        numCorrect++;
                        break;
                    }
                }
            }
            if (numCorrect == wordsOnGrid.get(i).getWord().length() && !wordsOnGrid.get(i).isFound()) {
                for (int l = 0; l < wordsOnGrid.get(i).getLetters().size(); l++) {
                    wordsOnGrid.get(i).getLetters().get(l).setStyle("-fx-background-color: green");
                    completedLabels.add(wordsOnGrid.get(i).getLetters().get(l));
                }
                wordsOnGrid.get(i).found();
                userWordList.getItems().remove(wordsOnGrid.get(i).getWord());
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
                    for (Label l : w.getLetters()) {
                        if (w.isFound() && l == labelsSelected.get(i)) {
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

    public void updateGridSize() {

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

                Label l = new Label(String.valueOf(Character.toChars((int) (Math.random() * 26) + 65))); // 26
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
        // WordFile wf = WordFile.grabCat("winter");
        // for (String s : wf.getWords()) {
        //     Direction d = Direction.RIGHT;
        //     int a = (int) (Math.random() * 8);
        //     switch (a) {
        //         case 0:
        //             d = Direction.RIGHT;
        //             break;
        //         case 1:
        //             d = Direction.LEFT;
        //             break;
        //         case 2:
        //             d = Direction.UP;
        //             break;
        //         case 3:
        //             d = Direction.DOWN;
        //             break;
        //         case 4:
        //             d = Direction.DOWN_LEFT_DIAGOINAL;
        //             break;
        //         case 5:
        //             d = Direction.DOWN_RIGHT_DIAGOINAL;
        //             break;
        //         case 6:
        //             d = Direction.UP_LEFT_DIAGOINAL;
        //             break;
        //         case 7:
        //             d = Direction.UP_RIGHT_DIAGOINAL;
        //             break;
        //     }
        //     placeWord(s, d);
        // }
        // title.setText(wf.getTitle());

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
        Label l = (Label) gridPane.getChildren().get(i * Integer.parseInt(gridSize.split("x")[0]) + j);
        switch (placement[j][i].getStatus()) {
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
        placeWord(a.getText(), direction);
        for (int i = 0; i < placement.length; i++) {
        for (int j = 0; j < placement[i].length; j++) {
        Label l = (Label) gridPane.getChildren().get(i * Integer.parseInt(gridSize.split("x")[0]) + j);
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