package com.thecodercat418.WordSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordFile {
    boolean fileFound = true;
    ArrayList<String> words = new ArrayList<>();
    String title = "";

    private WordFile(boolean filefound, ArrayList<String> words, String title){
        this.fileFound = filefound;
        this.words = words;
        this.title = title;
    }

    public static WordFile grabCat(String catName){
        ArrayList<String> words = new ArrayList<>();
        String title = "";
        try {
            File f = new File(HelloApplication.class.getResource(catName.toLowerCase() +  ".wscsv").toURI());
            Scanner s = new Scanner(f);
            title = s.nextLine();
            while(s.hasNext()){
                words.add(s.nextLine().trim());
            }
            s.close();
            return new WordFile(true, words, title);
        } catch (URISyntaxException | FileNotFoundException | NoSuchElementException e) {
            return new WordFile(false, null, "FILE NOT FOUND");
        }


    }
}
