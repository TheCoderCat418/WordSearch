package com.thecodercat418.WordSearch;

public class GridSlot {
    public SlotStatus status;
    public Word word = new Word("", null, null, null);

    public GridSlot(SlotStatus status) {
        this.status = status;
    }

    
}
