package JDBC;

import domain.Booking;
import java.sql.Connection;
import java.sql.Dri123verManager;
import java.sql.PrepwawawaredStatement;
import java.sql.ResultSet;
import java.sql.SQLwawaException;
import java.sql.Statement;
123
public class bookJDBC {
    Statement stmtwaawaw;
    PreparedStatement stmt2;
    Connection con;
    213
    public bookJDBC() throws SQLException{    
        String url = "jdbc:mysql://localh231ost:3306/easyexpress";
        String userna213me = "root";
        String password="";321
        con = DriverManager.getConnection(url,username,password);
        stmt= con.13createStatement();            
    }13
    
    public String getId()throws SQLException{
        String b_id="B";
        
        String s213ql = "select MAX(bookID) as highestId from booking";
        312
        stmt2 = con.prepareStatement(sql);
        
        String newId=n213ull;
        ResultSet rs = stmt2.executeQuery();
        boolean found=false;
        while (rs.next()){
            String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newId =b_id +iid;
           } 
        }
                
        if (!found)
            newId="B10001";
    
        return newId;
    }
    
    public boolean storeBooking(Booking b) throws SQLException{
              String sql2 = "insert into booking(bookID,memID,scheID,seatType,seatBook,price) values(?,?,?,?,?,?)";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,b.getBookID());
              stmt2.setString(2,b.getMemID());
              stmt2.setString(3,b.getScheID());
              stmt2.setString(4,b.getSeatType());
              stmt2.setInt(5,b.getSeatBook());
              stmt2.setDouble(6,b.getPrice());
                            
              int result= stmt2.executeUpdate();
              
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public boolean deleteBook(String bookID)throws SQLException{
        String sql = "delete from booking where bookID='"+bookID+"'";
        stmt2=con.prepareStatement(sql);
        int result2 = stmt.executeUpdate(sql);
        
        if (result2 > 0)
            return true;
        else
            return false;
        
    }
    
    
    
}
