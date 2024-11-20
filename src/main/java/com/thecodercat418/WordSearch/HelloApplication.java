package com.thecodercat418.WordSearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
         launch();
        // -1 slot in use
        //  0 slot avalible
        



        // Y, X
        // int[][] grid = new int[3][6];
        // System.out.println(grid.length + " " + grid[0].length);
        // for (int y = 0; y < grid.length; y++) {
        //     for (int x = 0; x < grid[y].length; x++) {
        //         grid[y][x] = 0;
        //     }
        // }

        // printArr(grid);

        // System.out.println("Added a 3 letter word");

    }

    // public static void printArr(int[][] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 0; j < arr[i].length; j++) {
    //             System.out.print(arr[i][j]+ " ");
    //         }
    //         System.out.println();
    //     }
    // }

    


}
