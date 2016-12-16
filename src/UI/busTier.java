package UI;

import JDBC.busJDBC;
import domain.Bus;
import java.util.ArrayList;

public class busTier {
    busJDBC jdbc;
    
    busTier() throws Exception{
        jdbc = new busJDBC();
    }
    
    public ArrayList getBusList()throws Exception{
        ArrayList busID = jdbc.getBusID();
        
        return busID;
    }
    
    public Bus retrieveBus(Bus b)throws Exception{
        
        b = jdbc.retrieveBusByID(b);
        
        return b;
    }
    
    public String createBus(String busName, int seat,int vip)throws Exception{
        String newId=jdbc.getId();
        Bus b = new Bus();
        b.setBusID(newId);
        b.setBusName(busName);
        b.setSeat(seat);
        b.setVip(vip);
        boolean success = jdbc.createBus(b);
        if(success)
            return b.getBusID();
            else
                return null;        
    }
    
    public boolean deleteBus(String busID)throws Exception{
            Bus b = new Bus();
            b.setBusID(busID);
                boolean success = jdbc.deleteBus(b);
                if(success)
                    return true;
                else
                    return false;
    }
    
    public boolean updateBus(String busID,String busName,int seat,int vip)throws Exception{
            Bus b = new Bus();
            b.setBusID(busID);
            b.setBusName(busName);
            b.setSeat(seat);
            b.setVip(vip);
                    boolean success = jdbc.updateBus(b);
                    if(success)
                        return true;
                                else
                        return false;
       }
    
    
}
