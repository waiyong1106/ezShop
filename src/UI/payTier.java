package UI;

import JDBC.payJDBC;
import domain.Payment;
import java.util.ArrayList;

public class payTier {
    payJDBC jdbc;
    
    payTier() throws Exception{
        jdbc = new payJDBC();
    }
    
    public String storepay(String bookID,String memID,String scheID,String scheDate,int scheTime,String seatType,int seatBook,double price,String payMethod,String cardNo,String cardPin)throws Exception{
        
        String newID = jdbc.getId();
        
        Payment p = new Payment();
        p.setPayID(newID);
        p.setBookID(bookID);
        p.setCardNo(cardNo);
        p.setCardPin(cardPin);
        p.setMemID(memID);
        p.setPayMethod(payMethod);
        p.setPrice(price);
        p.setScheDate(scheDate);
        p.setScheID(scheID);
        p.setScheTime(scheTime);
        p.setSeatBook(seatBook);
        p.setSeatType(seatType);
        
        boolean success = jdbc.storepay(p);
        if(success)
            return newID;
        else
            return null;
    }
    
    public ArrayList<Payment> retrievePay(String memID) throws Exception{
        ArrayList<Payment> payarray  = new ArrayList<Payment>();
        
        try{
            payarray = jdbc.retrievePay(memID);
         }catch(Exception ex){
             throw new Exception("No Record");
         } 
        return payarray;
    }
    
    public Payment retrievebyID(Payment p)throws Exception{
        
        p = jdbc.retrievebyID(p);
                
        return p;
    }
    
    public boolean cancelPay(String refundID,String payID)throws Exception{
        
        boolean success = jdbc.cancelPay(refundID,payID);
        if(success)
            return true;
        else
            return false;
    }
    
}
