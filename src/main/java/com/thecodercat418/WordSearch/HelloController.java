package com.thecodercat418.WordSearch;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class HelloController {
    @FXML
    private AnchorPane ap;
    @FXML
    private GridPane gridPane;
    private String gridSize = "26x26"; // EXCLUSIVE RxC
    private boolean selecting = false;
    private ArrayList<Label> labelsSelected = new ArrayList<>();

    public void onLetterClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().compareTo(MouseButton.SECONDARY) == 0) {
            for (int i = labelsSelected.size(); i < 0; i--) {
                labelsSelected.get(i).setStyle("");
                labelsSelected.remove(i);
            }
            selecting = false;
            return;
        }

        Label label = (Label) mouseEvent.getSource();
        label.setStyle("-fx-background-color: yellow");
        if (selecting = true) {
            String clickedLabelIndex = gridPane.getColumnIndex(label) + "," + gridPane.getRowIndex(label);
            boolean isNextTo = false;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    System.out.println(Integer.parseInt(gridSize.split("x")[0])*(gridPane.getRowIndex(label)+i)+gridPane.getColumnIndex(label)+j);
                    if(gridPane.getChildren().get(Integer.parseInt(gridSize.split("x")[0])*(gridPane.getRowIndex(label)+i)+gridPane.getColumnIndex(label)+j) == label){
                        isNextTo = true;
                    }
                }
            }
        }

        labelsSelected.add(label);
        selecting = true;
    }

    public void onMouseHover(MouseEvent actionEvent, boolean entering) {
        Label label = (Label) actionEvent.getSource();
        for (Label l : labelsSelected) {
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
            for (int j = 0; j < Integer.parseInt(gridSize.split("x")[1]); j++) {
                gridPane.getRowConstraints()
                        .add(new RowConstraints(gridPane.getPrefHeight() / Integer.parseInt(gridSize.split("x")[1])));
                Label l = new Label("0");
                l.setPrefWidth(gridPane.getPrefWidth() / Integer.parseInt(gridSize.split("x")[0]));
                l.setPrefHeight(gridPane.getPrefHeight() / Integer.parseInt(gridSize.split("x")[1]));
                l.setAlignment(Pos.CENTER);

                l.setOnMouseEntered(actionEvent -> {
                    onMouseHover(actionEvent, true);
                });
                l.setOnMouseExited(actionEvent -> {
                    onMouseHover(actionEvent, false);
                });
                l.setOnMouseClicked(actionEvent -> {
                    onLetterClicked(actionEvent);
                });

                gridPane.add(l, j, i);
            }
        }
    }
}