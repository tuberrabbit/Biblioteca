package com.twu.biblioteca;

/**
 * Created by Administrator on 2015/2/23.
 */
public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String... params) {
        if (params.length>0) {
            this.name = params[0];
        }
        if (params.length>1) {
            this.year = params[1];
        }
        if (params.length>2) {
            this.director = params[2];
        }
        if (params.length>3) {
            this.rating = params[3];
        }
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
}
