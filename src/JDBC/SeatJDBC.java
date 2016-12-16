package JDBC;

import domain.Seat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public SeatJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public boolean seatprice(Seat s)throws Exception{
        String sql3 = "select * from seat where scheID=?";
        stmt2 = con.prepareStatement(sql3);
        stmt2.setString(1,s.getScheID());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setScheID(rs.getString("scheID"));
            s.setNormal(rs.getInt("normal"));
            s.setVip(rs.getInt("vip"));
            s.setPriceN(rs.getDouble("priceN"));
            s.setPriceVip(rs.getDouble("priceVip"));
        }
        return true;
        
    }
        
    public boolean minusSeat(String scheID,String seatType,int seatBook)throws Exception{
        
        String sql2 = "select * from seat where scheID=?";
        stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1,scheID);
        Seat s = new Seat();
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setScheID(rs.getString("scheID"));
            s.setNormal(rs.getInt("normal"));
            s.setVip(rs.getInt("vip"));
            s.setPriceN(rs.getDouble("priceN"));
            s.setPriceVip(rs.getDouble("priceVip"));
        }
        
        if(seatType.equals("Normal")){
            int newseat = (s.getNormal()-seatBook);
            System.out.println(scheID+" "+newseat);
            String sql = "update seat set normal='"+newseat+"' where scheID='"+scheID+"'";
        
            int result2 = stmt.executeUpdate(sql);
        
            if (result2 > 0)
                return true;
            else
                return false;
        }else{
            int newseat = (s.getVip()-seatBook);
            System.out.println(scheID+" "+newseat);
            String sql = "update seat set vip='"+newseat+"' where scheID='"+scheID+"'";
            stmt2 = con.prepareStatement(sql);
        
            int result2 = stmt.executeUpdate(sql);
        
            if (result2 > 0)
                return true;
            else
                return false;
        }
    }
    
    public boolean addSeat(String scheID,String seatType,int seatBook)throws Exception{
        
        String sql2 = "select * from seat where scheID=?";
        stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1,scheID);
        Seat s = new Seat();
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setScheID(rs.getString("scheID"));
            s.setNormal(rs.getInt("normal"));
            s.setVip(rs.getInt("vip"));
            s.setPriceN(rs.getDouble("priceN"));
            s.setPriceVip(rs.getDouble("priceVip"));
        }
        
        if(seatType.equals("Normal")){
            int newseat = (s.getNormal()+seatBook);
            System.out.println(scheID+" "+newseat);
            String sql = "update seat set normal='"+newseat+"' where scheID='"+scheID+"'";
        
            int result2 = stmt.executeUpdate(sql);
        
            if (result2 > 0)
                return true;
            else
                return false;
        }else{
            int newseat = (s.getVip()+seatBook);
            System.out.println(scheID+" "+newseat);
            String sql = "update seat set vip='"+newseat+"' where scheID='"+scheID+"'";
            stmt2 = con.prepareStatement(sql);
        
            int result2 = stmt.executeUpdate(sql);
        
            if (result2 > 0)
                return true;
            else
                return false;
        }
    }
    
    public boolean addNewSeat(Seat s)throws SQLException{
        String sql = "insert into seat(scheID,normal,vip,priceN,priceVip) values(?,?,?,?,?)";
        stmt2 = con.prepareStatement(sql);
        stmt2.setString(1,s.getScheID());
        stmt2.setInt(2,s.getNormal());
        stmt2.setInt(3,s.getVip());
        stmt2.setDouble(4,s.getPriceN());
        stmt2.setDouble(5,s.getPriceVip());
        int result= stmt2.executeUpdate();
        System.out.println("ok");
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public boolean updateSeat(Seat s)throws SQLException{
        String sql6 = "update seat set scheID='"+s.getScheID()+"',normal='"+s.getNormal()+"',vip='"+s.getVip()+"',priceN='"+s.getPriceN()+"',priceVip='"+s.getPriceVip()+"' where scheID='"+s.getScheID()+"'";
        int result = stmt.executeUpdate(sql6);
        
        if (result > 0)
            return true;
        else
            return false;              
        
    }
           
        
}
