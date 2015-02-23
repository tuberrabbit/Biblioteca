package com.twu.biblioteca;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaApp {

    private Books books = new Books();
    private Movies movies = new Movies();
    private static List<String> menu = new ArrayList<String>();
    private String userName = "tuber";
    private Map<String, String> loginInfo = new HashMap<String, String>();
    private Map<String, User> userInfo = new HashMap<String, User>();
    private Scanner scanner = new Scanner(System.in);
    private User user = new User("tuber");

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.initMenu();
        app.initBooks();
        app.initMovie();
        app.initInfo();
        app.printWelcome();
        app.waitingForLogin();
        app.showMenuGetOptin(menu);
    }

    private void initInfo() {
        loginInfo.put("tuber", "tuber");
        userInfo.put("tuber", new User("tuber"));
    }

    private void initMovie() {
        Movie movie = new Movie("movie1", "1929", "Smith", "1");
        movies.add(movie);
    }

    private void waitingForLogin() {
        System.out.println("Please input your username:");
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            System.out.println("Please input your password:");
            if (login(command, scanner.nextLine(), loginInfo)) {
                userName = command;
                user = userInfo.get(userName);
                System.out.println("Successful login.");
                return;
            } else {
                System.out.println("username or password is error!\nPlease input your username:");
            }
        }
    }

    private void initBooks() {
        Book book1 = new Book("book1", "Alice", 1992);
        Book book2 = new Book("book2", "Bob", 1991);
        Book book3 = new Book("book3", "Tuber", 1990);
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    private void initMenu() {
        menu.add("List Books");
        menu.add("List Movies");
        menu.add("Check In");
        menu.add("Check Out Book");
        menu.add("Check Out Movie");
        menu.add("User Information");
    }

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca");
    }

    public void listBooks(Books books) {
        System.out.println("The list of Books:");
        Iterator iter = books.iterator();
        while (iter.hasNext()) {
            printBook((Book) iter.next());
        }
    }

    public void listMovies(Movies movies) {
        System.out.println("The list of Movies:");
        Iterator iter = movies.iterator();
        while (iter.hasNext()) {
            printMovie((Movie) iter.next());
        }
    }

    private void printMovie(Movie movie) {
        System.out.println(movie.getName() + " " + movie.getYear() + " " + movie.getDirector() + " " + movie.getRating());
    }

    private void printBook(Book book) {
        System.out.println(book.getName() + " " + book.getAuthor() + " " + book.getYearOfPublished());
    }

    public void showMenuGetOptin(List<String> menu) {
        System.out.println("Choose an option:");
        Iterator iter = menu.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        while (scanner.hasNextLine()) {
            final String str = scanner.nextLine();
            if (str.equals("Quit")) {
                break;
            }
            if (menu.contains(str)) {
                System.out.println("Your option is :" + str);
                if (str.equals("List Books")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            listBooks(books);
                        }
                    }.toDo();
                }
                if (str.equals("List Movies")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            listMovies(movies);
                        }
                    }.toDo();
                }
                if (str.equals("User Information")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            printUserInformation();
                        }
                    }.toDo();
                }
                if (str.equals("Check In")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            Book book = getBook();
                            String password = getPassword();
                            System.out.println(qurify(password) ? checkin(book, books) : "error in password!");
                        }

                        private String getPassword() {
                            System.out.println("Please input your password.");
                            return scanner.nextLine();
                        }

                        private Book getBook() {
                            String string = scanner.nextLine();
                            String[] params = string.trim().split(" ");
                            return new Book(params);
                        }
                    }.toDo();
                }
                if (str.equals("Check Out Book")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            Book book = getBook();
                            String password = getPassword();
                            System.out.println(qurify(password) ? checkoutBook(book, books) : "error in password!");
                        }

                        private String getPassword() {
                            System.out.println("Please input your password.");
                            return scanner.nextLine();
                        }

                        private Book getBook() {
                            String string = scanner.nextLine();
                            String[] params = string.trim().split(" ");
                            return new Book(params);
                        }
                    }.toDo();
                }
                if (str.equals("Check Out Movie")) {
                    new DoMenu() {
                        @Override
                        public void toDo() {
                            Movie movie = getMovie();
                            String password = getPassword();
                            System.out.println(qurify(password) ? checkoutMovie(movie, movies) : "error in password!");
                        }

                        private String getPassword() {
                            System.out.println("Please input your password.");
                            return scanner.nextLine();
                        }

                        private Movie getMovie() {
                            String string = scanner.nextLine();
                            String[] params = string.trim().split(" ");
                            return new Movie(params);
                        }
                    }.toDo();
                }
            } else {
                System.out.println("Select a valid option!");
            }
        }
    }

    private void printUserInformation() {
        System.out.println(user.getName() + '\n' + user.getEmail() + '\n' + user.getPhone());
    }

    private boolean qurify(String password) {
        return loginInfo.get(userName).equals(password);
    }

    public String checkoutBook(Book book, Books books) {
        if (books.contains(book)) {
            books.remove(book);
            user.setTimesOfCheckout(user.getTimesOfCheckout() + 1);
            return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }

    public String checkin(Book book, Books books) {
        if (!books.contains(book)) {
            books.add(book);
            user.setTimesOfCheckout(Math.max(user.getTimesOfCheckout() - 1, 0));//timesOfCheckout can not be negative!
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    public String checkoutMovie(Movie movie, Movies movies) {
        if (movies.contains(movie)) {
            movies.remove(movie);
            return "Thank you! Enjoy the movie";
        }
        return "That movie is not available.";
    }

    public boolean login(String user, String password, Map<String, String> loginInfo) {
        return loginInfo.containsKey(user) && loginInfo.get(user).equals(password);
    }
}
