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

    public Book(String... params) {
        if (params.length>0) {
            this.name = params[0];
        }
        if (params.length>1) {
            this.author = params[1];
        }
        if (params.length>2) {
            this.yearOfPublished = Integer.parseInt(params[2]);
        }
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
