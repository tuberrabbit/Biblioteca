package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
    }

    @Test
    public void test_print_welcome_message() throws Exception {
        app.printWelcome();
    }

    @Test
    public void test_list_books() throws Exception {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        app.listBooks(books);
    }

    @Test
    public void should_return_true_message_when_successful_checkout() throws Exception {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        assertThat(app.checkout(book3, books), is("Thank you! Enjoy the book"));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_checkout() throws Exception {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Book book4 = new Book("book3", "Tuber", 1990);
        assertThat(app.checkout(book4, books), is("That book is not available."));
    }

    @Test
    public void should_return_true_message_when_successful_checkin() throws Exception {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        books.add(book1);
        books.add(book2);
        
        Book book3 = new Book("book3", "Tuber", 1990);
        assertThat(app.checkin(book3, books), is("Thank you for returning the book."));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_checkin() throws Exception {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        
        assertThat(app.checkin(book3, books), is("That is not a valid book to return."));
    }
}