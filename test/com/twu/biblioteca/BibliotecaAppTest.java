package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private Books books;
    private Movies movies;
    private Map<String, String> loginInfo;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        books = new Books();
        movies = new Movies();
        loginInfo = new HashMap<String, String>();
    }

    @Test
    public void test_print_welcome_message() throws Exception {
        app.printWelcome();
    }

    @Test
    public void test_list_books() throws Exception {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        app.listBooks(books);
    }

    @Test
    public void test_list_movies() throws Exception {
        Movie movie = new Movie("movie1", "1929", "Smith", "1");
        movies.add(movie);
        
        app.listMovies(movies);
    }

    @Test
    public void should_return_true_message_when_successful_checkout_book() throws Exception {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        assertThat(app.checkoutBook(book3, books), is("Thank you! Enjoy the book"));
    }

    @Test
    public void should_return_true_message_when_successful_checkout_movie() throws Exception {
        Movie movie1 = new Movie("movie1");
        movies.add(movie1);
        assertThat(app.checkoutMovie(movie1, movies), is("Thank you! Enjoy the movie"));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_checkout_book() throws Exception {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Book book4 = new Book("book4", "Tuber", 1990);
        assertThat(app.checkoutBook(book4, books), is("That book is not available."));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_checkout_movie() throws Exception {
        Movie movie = new Movie("movie1");
        assertThat(app.checkoutMovie(movie, movies), is("That movie is not available."));
    }

    @Test
    public void should_return_true_message_when_successful_checkin() throws Exception {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        books.add(book1);
        books.add(book2);
        
        Book book3 = new Book("book3", "Tuber", 1990);
        assertThat(app.checkin(book3, books), is("Thank you for returning the book."));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_checkin() throws Exception {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        
        assertThat(app.checkin(book3, books), is("That is not a valid book to return."));
    }

    @Test
    public void should_return_false_message_when_unsuccessful_login() throws Exception {
        loginInfo.put("tuber", "tuber");
        assertThat(app.login("tuber", "password", loginInfo), is(false));
    }

    @Test
    public void should_return_true_message_when_successful_login() throws Exception {
        loginInfo.put("tuber", "tuber");
        assertThat(app.login("tuber", "tuber", loginInfo), is(true));
    }
}