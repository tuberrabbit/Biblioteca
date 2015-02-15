package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        List<String> menu = new ArrayList<String>();
        menu.add("List Books");
        app.showMenuGetOptin(menu);
    }

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca");
    }

    public void listBooks(List<Book> books) {
        System.out.println("The list of Books:");
        Iterator iter = books.iterator();
        while (iter.hasNext()) {
            printBook((Book) iter.next());
        }
    }

    private void printBook(Book book) {
        System.out.println(book.getName()+" "+book.getAuthor()+" "+book.getYearOfPublished());
    }

    public void showMenuGetOptin(List<String> menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        Iterator iter = menu.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals("Quit")) {
                break;
            }
            if (menu.contains(str)) {
                System.out.println("Your option is :"+str);
                //todo: do what you whant.
            } else {
                System.out.println("Select a valid option!");
            }
        }
    }

    public String checkout(Book book, List<Book> books) {
        if (books.contains(book)) {
            books.remove(book);
            return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }

    public String checkin(Book book, List<Book> books) {
        if (!books.contains(book)) {
            books.add(book);
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }
}
