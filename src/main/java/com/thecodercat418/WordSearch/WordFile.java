package com.thecodercat418.WordSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordFile {
    private boolean fileFound = true;
    private ArrayList<String> words = new ArrayList<>();
    private String title = "";

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

    public boolean isFileFound() {
        return fileFound;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getTitle() {
        return title;
    }

    
}
