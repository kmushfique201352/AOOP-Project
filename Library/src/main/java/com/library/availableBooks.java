package com.library;

import java.util.Date;

public class availableBooks {
    private final String title;
    private final String author;
    private final String genre;
    private final String image;
    private final String shelf;
    private final int quantity;

    public availableBooks(String title, String author, String genre, String image, String shelf,int quantity) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this. shelf=shelf;
        this.quantity=quantity;
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

    public String getShelf() {
        return shelf;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }
}
