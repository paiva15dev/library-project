import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookTools> books = new ArrayList<>();
    private List<Publisher> publishers = new ArrayList<>();
    private List<BorrowTools> borrowTools = new ArrayList<>();

   
    public void addBook(BookTools book) {
        this.books.add(book);  
    }

   
    public List<BookTools> listBookTools() {
        return books;
    }

    
    public List<BookTools> listAvailableBooks() { 
        List<BookTools> availableBooks = new ArrayList<>();
        for (BookTools book : books) {  
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks; 
    }
    public BookTools searchBookById(int id){
        for (BookTools book: books){
            if(book.getId()==id){
                return book;
            }
        }
            return null;
        }
    public void updateBook(int id, String newTitle){
        for(BookTools book: books){
            if(book.getId()==id){
                book.setTitle(newTitle);
                break;
            } else {
                System.out.println("Book not found!");
            }
        }
    }    
    
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);  
    }
    public List<Publisher> listPublishers(){
    return publishers;
          }  
          public void updatePublisher(int id, String newName) {
            for (Publisher publisher : publishers) {  
                if (publisher.getId() == id) {
                    publisher.setName(newName);  
                    break;  
                }
            }
        }
    public void removePublisher(int id) {
        publishers.removeIf(publisher -> publisher.getId()==id);
    }
    public void borrowBook(BookTools book, String userName) {
        if (book.isAvailable()) {
            BorrowTools borrowTool = new BorrowTools(book, userName);  
            this.borrowTools.add(borrowTool);  
            book.setAvailability(false);
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }
    public void returnBook(int idBorrow) {
        for (BorrowTools borrowTool : borrowTools) {  
            if (borrowTool.getId() == idBorrow && borrowTool.isActive()) {
                borrowTool.returnBook();  
                break;  
            }
        }
    }
    public List<BorrowTools> listBorrowTools() {
        return borrowTools;
    }
}
   
          
