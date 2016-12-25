package JDBC;

import domain.Payment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class payJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public payJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public String getId()throws SQLException{
        String p_id="P";
        
        String sql = "select MAX(payID) as highestId from payment";
        
        stmt2 = con.prepareStatement(sql);
        
        String newId=null;
        ResultSet rs = stmt2.executeQuery();
        boolean found=false;
        while (rs.next()){
            String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newId =p_id +iid;
           } 
        }
                
        if (!found)
            newId="P10001";
    
        return newId;
    }
    
    public boolean storepay(Payment p) throws SQLException{
              String sql2 = "insert into payment(payID,bookID,memID,scheID,scheDate,scheTime,seatType,seatBook,price,payMethod,cardNo,cardPin,refundID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,p.getPayID());
              stmt2.setString(2,p.getBookID());
              stmt2.setString(3,p.getMemID());
              stmt2.setString(4,p.getScheID());
              stmt2.setString(5,p.getScheDate());
              stmt2.setInt(6,p.getScheTime());
              stmt2.setString(7,p.getSeatType());
              stmt2.setInt(8,p.getSeatBook());
              stmt2.setDouble(9,p.getPrice());
              stmt2.setString(10,p.getPayMethod());
              if(p.getPayMethod().equals("Credit Card"))
              {
                stmt2.setString(11,p.getCardNo());
                stmt2.setString(12,p.getCardPin());
              }
              else
              {
                stmt2.setString(11,null);
                stmt2.setString(12,null);
              }
              stmt2.setString(13,"NULL");
              int result= stmt2.executeUpdate();
              
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public ArrayList<Payment> retrievePay(String memID)throws SQLException{
        
        ArrayList<Payment> payarray  = new ArrayList<Payment>();
                
            String sql2 = "select * from payment where memID=? AND refundID=?";
       
            stmt2 = con.prepareStatement(sql2);
            stmt2.setString(1,memID);
            stmt2.setString(2,"NULL");
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
            Payment p = new Payment();
            p.setPayID(rs.getString("payID"));
            p.setBookID(rs.getString("bookID"));
            p.setMemID(rs.getString("memID"));
            p.setScheID(rs.getString("scheID"));
            p.setScheDate(rs.getString("scheDate"));
            p.setScheTime(rs.getInt("scheTime"));
            p.setSeatType(rs.getString("seatType"));
            p.setSeatBook(rs.getInt("seatBook"));
            p.setPrice(rs.getDouble("price"));
            p.setPayMethod(rs.getString("payMethod"));
            p.setCardNo(rs.getString("cardNo"));
            p.setCardPin(rs.getString("cardPin"));                        
            
            payarray.add(p);
            }
            
        return payarray;
    }
    
    public Payment retrievebyID(Payment p)throws SQLException{
        String sql3 = "select * from payment where payID=?";
        stmt2 = con.prepareStatement(sql3);
        stmt2.setString(1,p.getPayID());
        ResultSet rs = stmt2.executeQuery();
        
        while(rs.next()){
            p.setPayID(rs.getString("payID"));
            p.setBookID(rs.getString("bookID"));
            p.setMemID(rs.getString("memID"));
            p.setScheID(rs.getString("scheID"));
            p.setScheDate(rs.getString("scheDate"));
            p.setScheTime(rs.getInt("scheTime"));
            p.setSeatType(rs.getString("seatType"));
            p.setSeatBook(rs.getInt("seatBook"));
            p.setPrice(rs.getDouble("price"));
            p.setPayMethod(rs.getString("payMethod"));
            p.setCardNo(rs.getString("cardNo"));
            p.setCardPin(rs.getString("cardPin"));        
        }
                
        return p;
    }
    
    public boolean cancelPay(String refundID,String payID)throws SQLException{
        String sql = "update payment set refundID='"+refundID+"' where payID='"+payID+"'";
        int result = stmt.executeUpdate(sql);
        
        if (result > 0)
            return true;
        else
            return false;
        
    }
    
    public ArrayList<Payment> retrievePay2()throws SQLException{
        
        ArrayList<Payment> payarray2  = new ArrayList<Payment>();
                
            String sql2 = "select * from payment ";
       
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
            Payment p = new Payment();
            p.setPayID(rs.getString("payID"));
            p.setBookID(rs.getString("bookID"));
            p.setMemID(rs.getString("memID"));
            p.setScheID(rs.getString("scheID"));
            p.setScheDate(rs.getString("scheDate"));
            p.setScheTime(rs.getInt("scheTime"));
            p.setSeatType(rs.getString("seatType"));
            p.setSeatBook(rs.getInt("seatBook"));
            p.setPrice(rs.getDouble("price"));
            p.setPayMethod(rs.getString("payMethod"));
            p.setCardNo(rs.getString("cardNo"));
            p.setCardPin(rs.getString("cardPin"));
            
            
            payarray2.add(p);
            }
            
        return payarray2;
    }
    
       
    
}
