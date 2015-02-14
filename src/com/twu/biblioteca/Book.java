package com.twu.biblioteca;

/**
 * Created by Administrator on 2015/2/14.
 */
public class Book {
    private String name;
    private String author;
    private int yearOfPublished;

    public Book(String name, String author, int yearOfPublished) {
        this.name = name;
        this.author = author;
        this.yearOfPublished = yearOfPublished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublished() {
        return yearOfPublished;
    }

    public void setYearOfPublished(int yearOfPublished) {
        this.yearOfPublished = yearOfPublished;
    }
}
