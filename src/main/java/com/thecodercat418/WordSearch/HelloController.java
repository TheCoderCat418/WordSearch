package com.thecodercat418.WordSearch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private AnchorPane ap;
    private GridPane gridPane;
     

    public void initialize(){
        gridPane = new GridPane();
        gridPane.setPrefHeight(600);
        gridPane.setPrefWidth(600);
        ap.getChildren().add(gridPane);
    }
}