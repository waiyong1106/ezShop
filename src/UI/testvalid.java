/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author han
 */
public class testvalid {

    public static void main(String[] args) {
        boolean valid = true;
        String invalid = "";
        String t = "2017-11-12";
        
        int day;
        int month;
        if (t.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"))
            valid=true;
        else{
            valid=false;
            invalid="Invalid Birthday Date format";
        }
        if(valid){
            day = Integer.parseInt(t.substring(8));
            month = Integer.parseInt(t.substring(5,7));
            if(day>31){
                valid=false;
                invalid = "Invalid Date";
            }
            if(month>12){
                valid=false;
                invalid = "Invalid Month";
            }
            
        }
        
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dd = sdf.parse(t);
        Calendar cal = Calendar.getInstance();
        String today = sdf.format(cal.getTime());
        Date tod = sdf.parse(today);
        
        if(dd.after(tod))
            valid=false;
            invalid="Birthday Cannot be furture date";
        }catch(Exception ex){
            
        }
        
        if(!valid)
            System.out.println(invalid);
        else
            System.out.println("OK");
        
        
    }
    
    
}
