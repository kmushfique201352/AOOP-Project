package com.library;

public class saveBook {
    private final String title;
    private final String author;
    private final String genre;
    private final String shelf;
    private final String image;

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

    public String getImage() {
        return image;
    }

    public saveBook(String title, String author, String genre, String image, String shelf) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.shelf = shelf;
        this.image=image;
    }
}
