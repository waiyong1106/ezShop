/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import JDBC.scheJDBC;
import domain.Scheduler;
import java.util.ArrayList;

/**
 *
 * @author han
 */
public class scheTier {
    scheJDBC jdbc;
    
    scheTier() throws Exception{
        jdbc = new scheJDBC();
    }
    
    public ArrayList<Scheduler> retrieveSche() throws Exception{
        ArrayList<Scheduler> schearray  = new ArrayList<Scheduler>();
        
        try{
            schearray = jdbc.retrieveSche();
         }catch(Exception ex){
             throw new Exception("No Record");
         } 
        return schearray;
    }
    
    public Scheduler retrieveByID(String scheID)throws Exception{
        
        Scheduler s = new Scheduler();
        s.setScheID(scheID);
        
        s = jdbc.retrieveByID(s);
        
        return s;
    }
    
    public String getNewID()throws Exception{
        String newID = jdbc.getNewID();
        
        return newID;
    }
    
    public boolean addSche(Scheduler sc)throws Exception{
        boolean success = jdbc.addSche(sc);
        if(success)
            return true;
        else
            return false;        
        
    }
    
    public boolean deleteSche(String scheID)throws Exception{
        boolean success = jdbc.deleteSche(scheID);
        if(success)
            return true;
        else
            return false;   
        
    }
    
    public boolean updateSche(Scheduler s)throws Exception{
        boolean success = jdbc.updateSche(s);
        if(success)
            return true;
        else
            return false;   
        
    }
    
}
