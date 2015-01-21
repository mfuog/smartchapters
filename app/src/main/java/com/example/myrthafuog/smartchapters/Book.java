package com.example.myrthafuog.smartchapters;

/**
 * Created by myrthafuog on 1/21/15.
 */
public class Book {
    private String title;
    private int numbChapters;
    private float XAxisInitial;
    private float XAxisClosed;

    public Book(String title, int numbChapters) {
        this.title = title;
        this.numbChapters = numbChapters;
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
