package UI;

import Domain.Driver;
import Domain.Driver;
import JDBC.driverJDBC;
import java.util.ArrayList;

public class driverTier {
    driverJDBC jdbc;
    
    driverTier() throws Exception{
        jdbc = new driverJDBC();
    }
    
    public ArrayList getDriverList()throws Exception{
        ArrayList driverID = jdbc.getDriverID();
        
        return driverID;
    }
    
    public String createDriver(String name,String handphone,String address,String birth,double salary,String busID)throws Exception{
   String newId=jdbc.getId();
   Driver d = new Driver();
   int hp = Integer.parseInt(handphone);
   d.setDriverID(newId);
   d.setDriverName(name);
   d.setHp(hp);
   d.setAddress(address);
   d.setBirth(birth);
   d.setSalary(salary);
   d.setBusID(busID);
   boolean success = jdbc.createDriver(d);
       
       if (success)
            return d.getDriverID();
       else
           return null;
    }
    
public boolean updateDriver(String driverID,String driverName, int hp, String address, String birth, double salary, String busID)throws Exception{
           
       
     Driver d = new Driver();
   d.setDriverID(driverID);
   d.setDriverName(driverName);
   d.setHp(hp);
   d.setAddress(address);
   d.setBirth(birth);
   d.setSalary(salary);
   d.setBusID(busID);
        boolean success = jdbc.updateDriver(d);
        return success;
    }
       public boolean deleteDriver(String driverID)throws Exception{
       Driver d= new Driver();
        d.setDriverID(driverID);
        boolean success = jdbc.deleteDriver(d);
        return success;
    }
         public Driver retriveStaff (String driverID) throws Exception{
        Driver d = new Driver ();
        d.setDriverID(driverID);
        
        boolean success = jdbc.retriveDriver(d);
        return d;
    }
         
         
}
