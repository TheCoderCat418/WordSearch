module com.thecodercat418.WordSearch {
    requires transitive javafx.controls;
    requires javafx.fxml;



    opens com.thecodercat418.WordSearch to javafx.fxml;
    exports com.thecodercat418.WordSearch;
}