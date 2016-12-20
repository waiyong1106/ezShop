package JDBC;

import domain.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public StaffJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public boolean stafflog(Staff s)throws SQLException{
        String sql3 = "select * from staff where username=? AND password=?";
        stmt2 = con.prepareStatement(sql3);
        stmt2.setString(1,s.getUsername());
        stmt2.setString(2,s.getPassword());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setStaffID(rs.getString("staffID"));
            s.setStaffName(rs.getString("staffName"));
            s.setAddress(rs.getString("address"));
            s.setBirth(rs.getString("birth"));
            s.setHp(rs.getString("hp"));
            s.setSalary(rs.getDouble("salary"));
            
        }
        return true;
                
    }
    
    public Staff passRecover(Staff s)throws SQLException{
        String sql4 = "select * from staff where username=? AND hp=?";
        stmt2 = con.prepareStatement(sql4);
        stmt2.setString(1,s.getUsername());
        stmt2.setString(2,s.getHp());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setPassword(rs.getString("password"));
        }
        return s;   //recovery successfully
    }
    
    public String getId()throws SQLException{
        String s_id="S";
        
        String sql = "select MAX(staffID) as highestId from staff";
        
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
            newId="S10001";
    
        return newId;
    }
    
    public boolean createStaff(Staff s)throws SQLException{
    String sql2="insert into staff(staffID,staffName,hp,address,birth,salary,username,password) values(?,?,?,?,?,?,?,?)";
    stmt2=con.prepareStatement(sql2);
    stmt2.setString(1,s.getStaffID());
    stmt2.setString(2,s.getStaffName());
    stmt2.setString(3,s.getHp());
    stmt2.setString(4,s.getAddress());
    stmt2.setString(5,s.getBirth());
    stmt2.setDouble(6,s.getSalary());
    stmt2.setString(7,s.getUsername());
    stmt2.setString(8,s.getPassword());
        
    int result2=stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false;
            
    }
    
    public ArrayList getStaffID()throws SQLException{
        
       ArrayList staffID = new ArrayList();
                
            String sql2 = "select Distinct staffID from staff";
        
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
                staffID.add(rs.getString("staffID"));
            }
            
        return staffID;
    }
    
    public boolean updateStaff(Staff s)throws SQLException{
    String sql2="update staff set staffName=?,hp=?,address=?,birth=?,salary=?,username=?,password=? where staffID=?";
    stmt2=con.prepareStatement(sql2);
    stmt2.setString(1,s.getStaffName());
    stmt2.setString(2,s.getHp());
    stmt2.setString(3,s.getAddress());
    stmt2.setString(4,s.getBirth());
    stmt2.setDouble(5,s.getSalary());
    stmt2.setString(6,s.getUsername());
    stmt2.setString(7,s.getPassword());
    stmt2.setString(8,s.getStaffID());
        
    int result2=stmt2.executeUpdate();
        if(result2>0)
            return true;
        else
            return false;
    }
    
    public Staff retrieveStaff(Staff s)throws SQLException{
        String sql2 = "select * from staff where staffID=?";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1, s.getStaffID());
              ResultSet rs = stmt2.executeQuery();
              while(rs.next()){
                  s.setStaffName(rs.getString("staffName"));
                  s.setHp(rs.getString("hp"));
                  s.setAddress(rs.getString("address"));
                  s.setBirth(rs.getString("birth"));
                  s.setSalary(rs.getDouble("salary"));  
                  s.setUsername(rs.getString("username"));
                  s.setPassword(rs.getString("password"));
              }
        
        return s;
    }
    
    public boolean deleteStaff(Staff s) throws SQLException{
              String sql2 = "delete from staff where staffID=?";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,s.getStaffID());
              int result2 = stmt2.executeUpdate();
              if (result2 > 0)
                  return true;
              else
                  return false;
    }
        
        
        
    }
