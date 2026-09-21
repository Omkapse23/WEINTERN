
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == book.getBookId()) {
                System.out.println("Book ID already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayBook();
        }
    }

    public void searchById(int bookId) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == bookId) {
                books.get(i).displayBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {

        boolean found = false;

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {

                books.get(i).displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void issueBook(int bookId) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == bookId) {

                if (books.get(i).isAvailable()) {
                    books.get(i).setAvailable(false);
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }


    public void returnBook(int bookId) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == bookId) {

                if (!books.get(i).isAvailable()) {
                    books.get(i).setAvailable(true);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void removeBook(int bookId) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == bookId) {

                if (!books.get(i).isAvailable()) {
                    System.out.println("Cannot remove an issued book.");
                    return;
                }

                books.remove(i);
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
}