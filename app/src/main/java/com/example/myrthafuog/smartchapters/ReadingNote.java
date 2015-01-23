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
    private int chapter;

    public ReadingNote(Book book){
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.text = "a note";
        readingNotes.put(this.id, this);
    }

    public String toString() {
        return this.text;
    };

    public static ReadingNote getReadingNote(String id){
        return readingNotes.get(id);
    }

    public static HashMap<String, ReadingNote> getReadingNotes() {
        return readingNotes;
    }

    public int calculateChapter(){
        // calculate remainingChapters based on retrieved value
        float perChapter = (this.book.getXAxisClosed() - this.book.getXAxisInitial()) / this.book.getNumbChapters();
        float remainingChapters = (this.getXAxisOpened() - this.book.getXAxisInitial()) / perChapter;
        float currentChapter = this.book.getNumbChapters() - remainingChapters;
        return (int) Math.abs(remainingChapters);
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
        this.chapter = calculateChapter();
    }

    public int getChapter() { return chapter; }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
}
