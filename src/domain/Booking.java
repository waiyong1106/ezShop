package domain;

public class Booking {
    private String bookID;
    private String memID;
    private String scheID;
    private String seatType;
    private int seatBook;
    private double price;

    public Booking() {
    }

    public Booking(String bookID, String memID, String scheID, String seatType, int seatBook, double price) {
        this.bookID = bookID;
        this.memID = memID;
        this.scheID = scheID;
        this.seatType = seatType;
        this.seatBook = seatBook;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getScheID() {
        return scheID;
    }

    public void setScheID(String scheID) {
        this.scheID = scheID;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatBook() {
        return seatBook;
    }

    public void setSeatBook(int seatBook) {
        this.seatBook = seatBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookID=" + bookID + ", memID=" + memID + ", scheID=" + scheID + ", seatType=" + seatType + ", seatBook=" + seatBook + ", price=" + price + '}';
    }
    
    
    
}
