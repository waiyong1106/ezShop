package domain;

public class Payment {
    private String payID;
    private String bookID;
    private String memID;
    private String scheID;
    private String scheDate;
    private int scheTime;
    private String seatType;
    private int seatBook;
    private double price;
    private String payMethod;
    private String cardNo;
    private String cardPin;

    public Payment() {
    }

    public Payment(String payID, String bookID, String memID, String scheID, String scheDate, int scheTime, String seatType, int seatBook, double price, String payMethod, String cardNo, String cardPin) {
        this.payID = payID;
        this.bookID = bookID;
        this.memID = memID;
        this.scheID = scheID;
        this.scheDate = scheDate;
        this.scheTime = scheTime;
        this.seatType = seatType;
        this.seatBook = seatBook;
        this.price = price;
        this.payMethod = payMethod;
        this.cardNo = cardNo;
        this.cardPin = cardPin;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
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

    public String getScheDate() {
        return scheDate;
    }

    public void setScheDate(String scheDate) {
        this.scheDate = scheDate;
    }

    public int getScheTime() {
        return scheTime;
    }

    public void setScheTime(int scheTime) {
        this.scheTime = scheTime;
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    @Override
    public String toString() {
        return "Payment{" + "payID=" + payID + ", bookID=" + bookID + ", memID=" + memID + ", scheID=" + scheID + ", scheDate=" + scheDate + ", scheTime=" + scheTime + ", seatType=" + seatType + ", seatBook=" + seatBook + ", price=" + price + ", payMethod=" + payMethod + ", cardNo=" + cardNo + ", cardPin=" + cardPin + '}';
    }
    
    
    
}
