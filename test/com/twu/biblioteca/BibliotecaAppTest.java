package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

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
    public void test_show_memu() throws Exception {
        List<String> menu = new ArrayList<String>();
        menu.add("List Books");

        app.showMenu(menu);
    }

    @Test
    public void should_return_true_when_select_true_menu() throws Exception {
        List<String> menu = new ArrayList<String>();
        menu.add("List Books");
        app.showMenu(menu);

        //Todo: 等待用户输入
    }
}