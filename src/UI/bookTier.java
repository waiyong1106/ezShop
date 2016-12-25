
package UI;

import JDBC.bookJDBC;
import domain.Booking;
import java.util.ArrayList;

public class bookTier {
    bookJDBC jdbc;
    
    bookTier() throws Exception{
        jdbc = new bookJDBC();
    }
    
    public String newbookID(String memID,String scheID,String seatType,int seatBook,double price)throws Exception{
        
        String newId = jdbc.getId();
        
        Booking b = new Booking();
        b.setBookID(newId);
        b.setMemID(memID);
        b.setScheID(scheID);
        b.setSeatType(seatType);
        b.setSeatBook(seatBook);
        b.setPrice(price);
        
        if(newId==null)
            return null;
        else
            return newId;
    }
    
    public boolean storebook(String bookID,String memID,String scheID,String seatType,int seatBook,double price)throws Exception{
        
        Booking b = new Booking();
        b.setBookID(bookID);
        b.setMemID(memID);
        b.setScheID(scheID);
        b.setSeatType(seatType);
        b.setSeatBook(seatBook);
        b.setPrice(price);
        
        boolean success = jdbc.storeBooking(b);
        if(success)
            return true;
        else
            return false;
    }
    
    public boolean deleteBook(String bookID)throws Exception{
        
        boolean success = jdbc.deleteBook(bookID);
        if(success)
            return true;
        else
            return false;        
    }

   public ArrayList<Booking> retrieveBook() throws Exception{
        ArrayList<Booking> bookarray  = new ArrayList<Booking>();
        
        try{
            bookarray = jdbc.retrieveBook();
         }catch(Exception ex){
             throw new Exception("No Record");
         } 
        return bookarray;
    }
    
    
    
}
