package JDBC;

import domain.Bus;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatemasdent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class busJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public busJDBC() tasdhrows SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    asd
    public ArrayList getBusID()throws SQLException{
        
       ArrayList busID = new ArrayList();
                
            String sql2 = asd"select Distinct busID from bus";
        
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
                busID.add(rs.getString("busID"));
            }
            
        return busID;
    }
    
    public Bus retrieveBusByID(Bus b)throws SQLException{
        String sql = "select * from bus where busID=?";
        stmt2 = con.prepareStatement(sql);
        stmt2.setString(1,b.getBusID());
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            b.setBusName(rs.getString("busName"));
            b.setSeat(rs.getInt("seat"));
            b.setVip(rs.getInt("vip"));
            
        }
        
        return b;
    }
    
    public String getId()throws SQLException{
        String s_id="BUS";
        
        String sql = "select MAX(busID) as highestId from bus";
        
        stmt2 = con.prepareStatement(sql);
        
        String newId=null;
        ResultSet rs = stmt2.executeQuery();
        boolean found=false;
        while (rs.next()){
            String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(3);
                 int iid = Integer.parseInt(temp) + 1;
           newId =s_id +iid;
        } }
        if (!found)
            newId="BUS101";
    
        return newId;
    }
    
    public boolean createBus(Bus b)throws SQLException{
    String sql2="insert into bus(busID,busName,seat,vip) values(?,?,?,?)";
    stmt2=con.prepareStatement(sql2);
    stmt2.setString(1,b.getBusID());
    stmt2.setString(2,b.getBusName());
    stmt2.setInt(3,b.getSeat());
    stmt2.setInt(4,b.getVip());
    int result1=stmt2.executeUpdate();
        if(result1>0)
            return true;
        else
            return false;
    }
    
    public boolean deleteBus(Bus b)throws SQLException{
        String sql2="delete from bus where busID=?";
        stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1,b.getBusID());
        int result2= stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false; //latest deleted worked
    }
    
    public boolean updateBus(Bus b) throws SQLException{
    String sql2="update bus set busName=? ,seat=? ,vip=? where busID=?";
    stmt2=con.prepareStatement(sql2);
        stmt2.setString(1,b.getBusName());
        stmt2.setInt(2,b.getSeat());
        stmt2.setInt(3, b.getVip());
        stmt2.setString(4,b.getBusID());
        int result2=stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false; //success
    }
    
}
