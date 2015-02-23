package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/2/23.
 */
public class Movies {
    private List<Movie> list = new ArrayList<Movie>();

    public void add(Movie movie) {
        list.add(movie);
    }

    public Iterator iterator() {
        return list.iterator();
    }

    public boolean contains(Movie movie) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Movie obj = (Movie) iter.next();
            String str1 = obj.getName()+obj.getYear()+obj.getDirector()+obj.getRating();
            String str2 = movie.getName()+movie.getYear()+movie.getDirector()+movie.getRating();
            if (str1.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void remove(Movie movie) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Movie obj = (Movie) iter.next();
            String str1 = obj.getName()+obj.getYear()+obj.getDirector()+obj.getRating();
            String str2 = movie.getName()+movie.getYear()+movie.getDirector()+movie.getRating();
            if (str1.equals(str2)) {
                list.remove(obj);
                return;
            }
        }
    }
}
