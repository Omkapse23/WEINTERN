
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = readInt(sc);

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.viewAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int searchId = readInt(sc);

                    library.searchById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Book Title: ");
                    String searchTitle = sc.nextLine();

                    library.searchByTitle(searchTitle);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int issueId = readInt(sc);

                    library.issueBook(issueId);
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    int returnId = readInt(sc);

                    library.returnBook(returnId);
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int removeId = readInt(sc);

                    library.removeBook(removeId);
                    break;

                case 8:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }

    public static int readInt(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.nextLine();
        }

        int value = sc.nextInt();
        sc.nextLine();

        return value;
    }
}