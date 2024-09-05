import java.util.Date;

public class BorrowTools {
    private int id;
    private static int idCounter=1;
    private BookTools bookTools;
    private String userName;
    private Date dateBorrow;
    private Date dateReturn;
    private Boolean active;

    public BorrowTools (BookTools bookTools,String userName) {
        this.id = idCounter++;
        this.bookTools = bookTools;
        this.userName = userName;
        this.dateBorrow = new Date();
        this.active = true;
       }
       public int getId() {
        return id;
    }

    public BookTools getBookTools() {
        return bookTools;
    }

    public String getuserName() {
        return userName;
    }

    public Date getdateBorrow() {
        return dateBorrow;
    }

    public Date getdateReturn() {
        return dateReturn;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.dateReturn = new Date();
        this.active = false;
        this.bookTools.setAvailability(true);
    }
    
}