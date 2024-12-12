package com.thecodercat418.WordSearch;

public class GridSlot {
    private SlotStatus status;
    private Word word = new Word("", null, Direction.NOTSET, null);
    public GridSlot(SlotStatus status) {
        this.status = status;
    }
    public SlotStatus getStatus() {
        return status;
    }
    public void setStatus(SlotStatus status) {
        this.status = status;
    }
    public Word getWord() {
        return word;
    }
    public void setWord(Word word) {
        this.word = word;
    }

    
}
