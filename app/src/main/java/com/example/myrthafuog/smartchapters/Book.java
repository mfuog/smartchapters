package com.example.myrthafuog.smartchapters;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by myrthafuog on 1/21/15.
 */
public class Book {
    private static final HashMap<String, Book> books = new HashMap<String, Book>();

    private final String id;
    private String title;
    private int numbChapters;
    private float XAxisInitial;
    private float XAxisClosed;

    public Book(String title, int numbChapters) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.numbChapters = numbChapters;
        books.put(this.id, this);
    }

    public static Book getBook(String id){
        return books.get(id);
    }

    public static HashMap<String, Book> getBooks() {
        return books;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumbChapters() {
        return numbChapters;
    }

    public void setNumbChapters(int numbChapters) {
        this.numbChapters = numbChapters;
    }

    public float getXAxisInitial() {
        return XAxisInitial;
    }

    public void setXAxisInitial(float XAxisInitial) {
        this.XAxisInitial = XAxisInitial;
    }

    public float getXAxisClosed() {
        return XAxisClosed;
    }

    public void setXAxisClosed(float XAxisClosed) {
        this.XAxisClosed = XAxisClosed;
    }
}
