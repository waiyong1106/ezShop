/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import domain.Scheduler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author han
 */
public class scheJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public scheJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public ArrayList<Scheduler> retrieveSche()throws SQLException{
        
        ArrayList<Scheduler> schearray  = new ArrayList<Scheduler>();
                
            String sql2 = "select * from scheduler";
        
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
            Scheduler s = new Scheduler();
            s.setScheID(rs.getString("scheID"));
            s.setScheDate(rs.getString("scheDate"));
            s.setDeparture(rs.getString("departure"));
            s.setBusID(rs.getString("busID"));
            s.setDest(rs.getString("dest"));
            s.setDriverID(rs.getString("driverID"));
                        
            String sql = "select * from seat where scheID=?";
            stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,s.getScheID());
            ResultSet rs2 = stmt2.executeQuery();
            while(rs2.next()){
                s.setNormal(rs2.getString("normal"));
                s.setVip(rs2.getString("vip"));
            }
            
            schearray.add(s);
            }
            
        return schearray;
    }
    
    public Scheduler retrieveByID(Scheduler s)throws SQLException{
        String sql3 = "select * from scheduler where scheID=?";
        stmt2 = con.prepareStatement(sql3);
        stmt2.setString(1,s.getScheID());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            s.setScheID(rs.getString("scheID"));
            s.setScheDate(rs.getString("scheDate"));
            s.setDest(rs.getString("dest"));
            s.setDeparture(rs.getString("departure"));
            s.setBusID(rs.getString("busID"));
            s.setDriverID(rs.getString("driverID"));
            
            String sql = "select * from seat where scheID=?";
            stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,s.getScheID());
            ResultSet rs2 = stmt2.executeQuery();
            while(rs2.next()){
                s.setNormal(rs2.getString("normal"));
                s.setVip(rs2.getString("vip"));
            }            
        }
        return s;
                
    }
    
    public String getNewID()throws SQLException{
        String sche_id = "SC";
        
        String sql = "select MAX(scheID) as highestId from scheduler";
        
        stmt2 = con.prepareStatement(sql);
        
        String newId=null;
        ResultSet rs = stmt2.executeQuery();
        boolean found=false;
        while (rs.next()){
            String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(2);
                 int iid = Integer.parseInt(temp) + 1;
           newId =sche_id +iid;
           } 
        }
                
        if (!found)
            newId="SC1001";
    
        return newId;
    }
        
    public boolean addSche(Scheduler sc)throws SQLException{
        String sql = "insert into scheduler(scheID,scheDate,dest,departure,busID,driverID) values(?,?,?,?,?,?)";
        stmt2 = con.prepareStatement(sql);
        stmt2.setString(1,sc.getScheID());
        stmt2.setString(2,sc.getScheDate());
        stmt2.setString(3,sc.getDest());
        stmt2.setInt(4,Integer.parseInt(sc.getDeparture()));
        stmt2.setString(5,sc.getBusID());
        stmt2.setString(6,sc.getDriverID());
        
        int result= stmt2.executeUpdate();
              
              if (result > 0)
                   return true;
              else
                  return false;
        
    }
    
    public boolean deleteSche(String scheID)throws SQLException{
        String sql = "delete from scheduler where scheID ='"+scheID+"'";
        int result2 = stmt.executeUpdate(sql);
        
        String sql2 = "delete from seat where scheID ='"+scheID+"'";
        int result = stmt.executeUpdate(sql2);
        
        if (result2 > 0 && result > 0)
            return true;
        else
            return false;
        
    }    
    
    public boolean updateSche(Scheduler s)throws SQLException{
        String sql6 = "update scheduler set scheID='"+s.getScheID()+"',scheDate='"+s.getScheDate()+"',dest='"+s.getDest()+"',departure='"+s.getDeparture()+"',busID='"+s.getBusID()+"',driverID='"+s.getDriverID()+"' where scheID='"+s.getScheID()+"'";
        int result = stmt.executeUpdate(sql6);
        
        if (result > 0)
            return true;
        else
            return false;        
        
    }
    
        
}
