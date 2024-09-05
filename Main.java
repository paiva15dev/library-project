import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int option;

        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books");
            System.out.println("3. List available books");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Add a new publisher");
            System.out.println("7. List all publishers");
            System.out.println("8. Update a book title");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    // Add a new book
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter publisher ID: ");
                    int publisherId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter publisher name: ");
                    String publisherName = scanner.nextLine();
                    
                    
                    System.out.print("Enter publisher date of birth (dd/MM/yyyy): ");
                    String dobString = scanner.nextLine();
                    Date dateOfBirth = null;
                    try {
                        dateOfBirth = dateFormat.parse(dobString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        continue; 
                    }
                    
                    
                    Publisher publisher = new Publisher(publisherId, publisherName, dateOfBirth);
                    library.addPublisher(publisher);

                    
                    BookTools newBook = new BookTools(id, title, publisher);
                    library.addBook(newBook);

                    System.out.println("Book and publisher added successfully!");
                    break;

                case 2:
                    
                    System.out.println("Listing all books:");
                    for (BookTools book : library.listBookTools()) {
                        System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + 
                                           ", Publisher: " + book.getPublisher().getName());
                    }
                    break;

                case 3:
                    
                    System.out.println("Listing available books:");
                    for (BookTools availableBook : library.listAvailableBooks()) {
                        System.out.println("ID: " + availableBook.getId() + ", Title: " + availableBook.getTitle());
                    }
                    break;

                case 4:
                    
                    System.out.print("Enter the ID of the book to borrow: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();

                    BookTools bookToBorrow = library.searchBookById(borrowId);
                    if (bookToBorrow != null) {
                        library.borrowBook(bookToBorrow, userName);
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    // Return a book
                    System.out.print("Enter the borrow ID to return the book: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine();  

                    library.returnBook(returnId);
                    System.out.println("Book returned successfully!");
                    break;

                case 6:
                    
                    System.out.print("Enter publisher ID: ");
                    int newPublisherId = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter publisher name: ");
                    String newPublisherName = scanner.nextLine();

                    System.out.print("Enter publisher date of birth (dd/MM/yyyy): ");
                    String newDobString = scanner.nextLine();
                    Date newDateOfBirth = null;
                    try {
                        newDateOfBirth = dateFormat.parse(newDobString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        continue; 
                    }

                    Publisher newPublisher = new Publisher(newPublisherId, newPublisherName, newDateOfBirth);
                    library.addPublisher(newPublisher);
                    System.out.println("Publisher added successfully!");
                    break;

                case 7:
                    
                    System.out.println("Listing all publishers:");
                    for (Publisher pub : library.listPublishers()) {
                        System.out.println("ID: " + pub.getId() + ", Name: " + pub.getName() +
                                           ", Date of Birth: " + dateFormat.format(pub.getDateOfBirth()));
                    }
                    break;

                case 8:
                    
                    System.out.print("Enter the ID of the book to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter the new title: ");
                    String newTitle = scanner.nextLine();

                    library.updateBook(updateId, newTitle);
                    System.out.println("Book title updated successfully!");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}
