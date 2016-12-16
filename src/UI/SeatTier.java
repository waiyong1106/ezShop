package UI;

import JDBC.SeatJDBC;
import domain.Seat;

public class SeatTier {
    SeatJDBC jdbc;
    
    SeatTier() throws Exception{
        jdbc = new SeatJDBC();
    }
    
    public Seat seatprice(Seat s)throws Exception{
        
        boolean success = jdbc.seatprice(s);
        if(success)
            return s;
        else
            return null;
        
    }
    
    public boolean minusSeat(String scheID,String seatType,int seatBook)throws Exception{
        boolean success;
        
        success = jdbc.minusSeat(scheID,seatType,seatBook);
        
        if(success)
            return true;
        else
            return false;
    
    }
    
    public boolean addSeat(String scheID,String seatType,int seatBook)throws Exception{
        boolean success;
        
        success = jdbc.addSeat(scheID,seatType,seatBook);
        
        if(success)
            return true;
        else
            return false;
    
    }
    
    public boolean addNewSeat(Seat s)throws Exception{
        boolean success = jdbc.addNewSeat(s);
        
        if(success)
            return true;
        else
            return false;
    }
    
    public boolean updateSeat(Seat s)throws Exception{
        boolean success = jdbc.updateSeat(s);
        if(success)
            return true;
        else
            return false;
        
    }
    
    
}
