package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/2/23.
 */
public class Books {
    private List<Book> list = new ArrayList<Book>();

    public void add(Book book) {
        list.add(book);
    }

    public void remove(Book book) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Book obj = (Book) iter.next();
            String str1 = obj.getName()+obj.getAuthor()+obj.getYearOfPublished();
            String str2 = book.getName()+book.getAuthor()+book.getYearOfPublished();
            if (str1.equals(str2)) {
                list.remove(obj);
                return;
            }
        }
    }

    public Iterator iterator() {
        return list.iterator();
    }

    public boolean contains(Book book) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Book obj = (Book) iter.next();
            String str1 = obj.getName()+obj.getAuthor()+obj.getYearOfPublished();
            String str2 = book.getName()+book.getAuthor()+book.getYearOfPublished();
            if (str1.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
