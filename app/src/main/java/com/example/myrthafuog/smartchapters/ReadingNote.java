package com.example.myrthafuog.smartchapters;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by myrthafuog on 1/21/15.
 */
public class ReadingNote {
    private static final HashMap<String, ReadingNote> readingNotes = new HashMap<String, ReadingNote>();

    private final String id;
    private final Book book;
    private String text;
    private float XAxisOpened;

    public ReadingNote(Book book){
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.text = "a note";
        readingNotes.put(this.id, this);
    }

    public String toString() {
        return this.text;
    };

    public int getChapter(ReadingNote note){
        // calculate: (book.XAxisInitial - book.XAxisClosed) / book.numChapters * this.XAxis
        return 2;
    }

    public static ReadingNote getReadingNote(String id){
        return readingNotes.get(id);
    }

    public static HashMap<String, ReadingNote> getReadingNotes() {
        return readingNotes;
    }

    public String getId(){
        return this.id;
    }

    public Book getBook() {
        return book;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getXAxisOpened() {
        return XAxisOpened;
    }

    public void setXAxisOpened(float XAxisOpened) {
        this.XAxisOpened = XAxisOpened;
    }
}
