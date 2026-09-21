
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== Java Collections Challenge =====");
            System.out.println("1. ArrayList Challenge");
            System.out.println("2. HashMap Challenge");
            System.out.println("3. Queue Challenge");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:
                    arrayListChallenge(sc);
                    break;

                case 2:
                    hashMapChallenge(sc);
                    break;

                case 3:
                    queueChallenge(sc);
                    break;

                case 4:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

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

    // ==========================================
    // ARRAYLIST CHALLENGE
    // ==========================================

    public static void arrayListChallenge(Scanner sc) {

        ArrayList<String> books = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== ArrayList Challenge =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Books");
            System.out.println("6. Back");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:

                    System.out.print("Enter book title: ");
                    String book = sc.nextLine();

                    books.add(book);

                    System.out.println("Book added successfully.");
                    break;

                case 2:

                    System.out.print("Enter book title to remove: ");
                    String removeBook = sc.nextLine();

                    boolean removed = false;

                    for (int i = 0; i < books.size(); i++) {

                        if (books.get(i).equalsIgnoreCase(removeBook)) {

                            books.remove(i);

                            System.out.println("Book removed successfully.");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Book not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter book index to update: ");
                    int index = readInt(sc);

                    if (index >= 0 && index < books.size()) {

                        System.out.print("Enter new book title: ");
                        String newBook = sc.nextLine();

                        books.set(index, newBook);

                        System.out.println("Book updated successfully.");

                    } else {

                        System.out.println("Invalid index.");
                    }

                    break;

                case 4:

                    System.out.print("Enter book title to search: ");
                    String searchBook = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < books.size(); i++) {

                        if (books.get(i).equalsIgnoreCase(searchBook)) {

                            System.out.println("Book found at index: " + i);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }

                    break;

                case 5:

                    if (books.isEmpty()) {

                        System.out.println("No books available.");

                    } else {

                        System.out.println("\nBook List:");

                        for (int i = 0; i < books.size(); i++) {

                            System.out.println(i + ": " + books.get(i));
                        }
                    }

                    break;

                case 6:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // ==========================================
    // HASHMAP CHALLENGE
    // ==========================================

    public static void hashMapChallenge(Scanner sc) {

        HashMap<Integer, String> students = new HashMap<>();

        int choice;

        do {

            System.out.println("\n===== HashMap Challenge =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Retrieve Student");
            System.out.println("3. Update Student");
            System.out.println("4. Check Student ID");
            System.out.println("5. Display Students");
            System.out.println("6. Back");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:

                    System.out.print("Enter student ID: ");
                    int id = readInt(sc);

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    students.put(id, name);

                    System.out.println("Student inserted successfully.");
                    break;

                case 2:

                    System.out.print("Enter student ID: ");
                    int searchId = readInt(sc);

                    if (students.containsKey(searchId)) {

                        System.out.println("Student Name: "
                                + students.get(searchId));

                    } else {

                        System.out.println("Student ID not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter student ID: ");
                    int updateId = readInt(sc);

                    if (students.containsKey(updateId)) {

                        System.out.print("Enter new student name: ");
                        String newName = sc.nextLine();

                        students.put(updateId, newName);

                        System.out.println("Student updated successfully.");

                    } else {

                        System.out.println("Student ID not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter student ID: ");
                    int checkId = readInt(sc);

                    if (students.containsKey(checkId)) {

                        System.out.println("Student ID exists.");

                    } else {

                        System.out.println("Student ID does not exist.");
                    }

                    break;

                case 5:

                    if (students.isEmpty()) {

                        System.out.println("No students available.");

                    } else {

                        System.out.println("\nStudent Records:");

                        for (Integer studentId : students.keySet()) {

                            System.out.println(studentId + " -> "
                                    + students.get(studentId));
                        }
                    }

                    break;

                case 6:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // ==========================================
    // QUEUE CHALLENGE
    // ==========================================

    public static void queueChallenge(Scanner sc) {

        Queue<String> queue = new LinkedList<>();

        int choice;

        do {

            System.out.println("\n===== Queue Challenge =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Peek Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:

                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine();

                    queue.add(customer);

                    System.out.println("Customer added to queue.");
                    break;

                case 2:

                    if (queue.isEmpty()) {

                        System.out.println("Queue is empty.");

                    } else {

                        String removedCustomer = queue.poll();

                        System.out.println("Removed customer: "
                                + removedCustomer);
                    }

                    break;

                case 3:

                    if (queue.isEmpty()) {

                        System.out.println("Queue is empty.");

                    } else {

                        System.out.println("Front customer: "
                                + queue.peek());
                    }

                    break;

                case 4:

                    if (queue.isEmpty()) {

                        System.out.println("Queue is empty.");

                    } else {

                        System.out.println("\nQueue Contents:");

                        Object[] customers = queue.toArray();

                        for (int i = 0; i < customers.length; i++) {

                            System.out.println(customers[i]);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}