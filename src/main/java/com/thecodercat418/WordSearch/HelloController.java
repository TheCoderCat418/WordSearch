package com.thecodercat418.WordSearch;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class HelloController {
    @FXML
    private AnchorPane ap;
    @FXML
    private GridPane gridPane;
    private String gridSize = "25x25"; //EXCLUSIVE RxC

    public void running(){
        System.out.println("YEah");
    }
     

    public void initialize(){
        gridPane.getChildren().clear();
        
        for(int i = 0; i<Integer.parseInt(gridSize.split("x")[0]); i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(gridPane.getPrefWidth()/Integer.parseInt(gridSize.split("x")[0])));
            for(int j = 0; j<Integer.parseInt(gridSize.split("x")[1]); j++){
                gridPane.getRowConstraints().add(new RowConstraints(gridPane.getPrefHeight()/Integer.parseInt(gridSize.split("x")[1])));
                Label l = new Label("0");
                l.setPrefWidth(gridPane.getPrefWidth()/Integer.parseInt(gridSize.split("x")[0]));
                l.setAlignment(Pos.CENTER);

                l.setOnMouseEntered(actionEvent -> {
                    l.setStyle("-fx-background-color: gray");
                });
                l.setOnMouseExited(actionEvent -> {
                    l.setStyle("");
                });
                l.setOnMouseClicked(actionEvent -> {
                    l.setStyle("-fx-background-color: yellow");
                });





                gridPane.add(l, j, i);
            }
        }
    }
}