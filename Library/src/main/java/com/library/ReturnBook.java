package com.library;

import java.util.Date;

public class ReturnBook {
    private final String title;
    private final String author;
    private final String genre;
    private final Date date;

    public String getImage() {
        return image;
    }

    private final String image;

    public ReturnBook(String title, String author, String genre, String image,Date date) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;
        this.image=image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDate() {
        return date;
    }
}
