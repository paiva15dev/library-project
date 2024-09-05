import java.util.Date;

public class BookTools {
    private int id; 
    private String title;
    private Publisher publisher;
    private boolean availability;
    private Date dateOfRegister;
    private Date dateOfUpDate;
    
    public BookTools(int id, String title, Publisher publisher) { 
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.availability = true;
        this.dateOfRegister = new Date();
        this.dateOfUpDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Publisher getPublisher() { 
        return publisher;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;  
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

    public Date getDateOfUpDate() {
        return dateOfUpDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.dateOfUpDate = new Date();  
    }
    
    }

