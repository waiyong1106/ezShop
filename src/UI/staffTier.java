package UI;

import JDBC.StaffJDBC;
import domain.Staff;
import java.util.ArrayList;

public class staffTier {
    StaffJDBC jdbc;
    
    staffTier() throws Exception{
        jdbc = new StaffJDBC();
    }
    
    public String stafflog(String username,String password)throws Exception{
        
        Staff s = new Staff();
        s.setUsername(username);
        s.setPassword(password);
        
        boolean success = jdbc.stafflog(s);
        if(success)
            return s.getStaffName();
        else
            return null;
        
    }
    
    public Staff passRecover(String username,String hp)throws Exception{
        
        Staff s = new Staff();
        s.setHp(hp);
        s.setUsername(username);
        s = jdbc.passRecover(s);
        
        return s;
    }
    
    public String createStaff(String name,String handphone,String address,String birth,double salary,String username,String password)throws Exception{
        
        String newId = jdbc.getId();
        
        Staff s = new Staff();
        s.setAddress(address);
        s.setBirth(birth);
        s.setHp(handphone);
        s.setPassword(password);
        s.setSalary(salary);
        s.setStaffID(newId);
        s.setUsername(username);
        s.setStaffName(name);
        
        boolean success = jdbc.createStaff(s);
        if(success)
            return newId;
        else
            return null;
        
    }
    
    public ArrayList getStaffList()throws Exception{
        ArrayList staffID = jdbc.getStaffID();
        
        return staffID;
    }
    
    public boolean updateStaff(Staff s)throws Exception{
        boolean success = jdbc.updateStaff(s);
                    if(success)
                        return true;
                                else
                        return false;
        
    }
    
    public Staff retrieveStaff(Staff s)throws Exception{
        s = jdbc.retrieveStaff(s);
        return s;
    }
    
    public boolean deleteStaff(String StaffID)throws Exception{
       Staff s= new Staff();
        s.setStaffID(StaffID);
        boolean success = jdbc.deleteStaff(s);
        return success;
    }
    
    
    
}
