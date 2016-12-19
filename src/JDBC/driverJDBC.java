package JDBC;

import Domain.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class driverJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public driverJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public ArrayList getDriverID()throws SQLException{
        
       ArrayList driverID = new ArrayList();
                
            String sql2 = "select Distinct driverID from driver";
        
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
                driverID.add(rs.getString("driverID"));
            }
            
        return driverID;
    }
    
    public String getId() throws SQLException {
        String s_id = "D";

        String sql = "select MAX(driverID) as highestId from driver";

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
           newId =s_id +iid;
      
        } 
	}
                
        
        if (!found)
            newId="D10001";
    
        return newId;
    }
  
  public boolean createDriver(Driver d)throws SQLException{
    String sql2="insert into driver(driverId,driverName,hp,address,birth,salary,busID) values(?,?,?,?,?,?,?)";
    stmt2=con.prepareStatement(sql2);
    stmt2.setString(1,d.getDriverID());
    stmt2.setString(2,d.getDriverName());
    stmt2.setInt(3,d.getHp());
    stmt2.setString(4,d.getAddress());
    stmt2.setString(5,d.getBirth());
    stmt2.setDouble(6,d.getSalary());
    stmt2.setString(7,d.getBusID());
   
        
    int result2=stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false;
}
  public boolean updateDriver(Driver d)throws SQLException{
    String sql2="update driver set driverName=?,hp=?,address=?, birth=?,salary=?,busID=? where driverID=?";
    stmt2=con.prepareStatement(sql2);
    stmt2.setString(1,d.getDriverName());
    stmt2.setInt(2,d.getHp());
    stmt2.setString(3,d.getAddress());
    stmt2.setString(4,d.getBirth());
    stmt2.setDouble(5,d.getSalary());
   stmt2.setString(6,d.getBusID());
   stmt2.setString(7,d.getDriverID());
            
    int result2=stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false;
}
   public boolean deleteDriver(Driver d) throws SQLException{
              String sql2 = "delete from driver where driverID=?";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,d.getDriverID());
              int result2 = stmt2.executeUpdate();
              if (result2 > 0)
                  return true;
              else
                  return false;
    }
     public boolean retriveDriver(Driver d)throws SQLException{
       
              String sql2 = "select * from driver where driverID=?";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1, d.getDriverID());
              ResultSet rs = stmt2.executeQuery();
              while(rs.next()){
                  d.setDriverName(rs.getString("driverName"));
                  d.setHp(rs.getInt("hp"));
                  d.setAddress(rs.getString("Address"));
                  d.setBirth(rs.getString("birth"));
                  d.setSalary(rs.getDouble("salary"));
                  d.setBusID(rs.getString("busID"));
              }
        
        return true;
    }
         
     
}
