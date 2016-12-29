package JDBC;

import domain.Refund;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class refundJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public refundJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    //This method is to compare the refund table database, and get the next data's id
    public String getId()throws SQLException{
        String r_id="R";
        
        String sql = "select MAX(refundID) as highestId from refund";
        
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
           newId =r_id +iid;
           } 
        }
                
        if (!found)
            newId="R10001";
    
        return newId;
    }
    
    //This method is use to get the member's phone number by using member id
    public String getHp(String memID)throws Exception{
        String hp="null";
        String sql2 = "select hp from member where memID=?";
        stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1,memID);
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            hp = rs.getString("hp");
        }
                
        return hp;
    }
    
    //This method is use to add in new refund data into database
    public boolean storeRefund(Refund r)throws Exception{
              String sql2 = "insert into refund(refundID,payID,memID,hp,rprice,status) values(?,?,?,?,?,?)";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,r.getRefundID());
              stmt2.setString(2,r.getPayID());
              stmt2.setString(3,r.getMemID());
              stmt2.setString(4,r.getHp());
              stmt2.setDouble(5,r.getRprice());
              stmt2.setString(6,r.getStatus());
                            
              int result= stmt2.executeUpdate();
              
              if (result > 0)
                   return true;
              else
                  return false;
        
    }
    
    //This method return the data in refund table in a ArrayList form so that it can be shown in table
    public ArrayList<Refund> retrieveRefund()throws SQLException{
        
        ArrayList<Refund> refundarray  = new ArrayList<Refund>();
                
            String sql2 = "select * from refund";
        
            stmt2 = con.prepareStatement(sql2);
            ResultSet rs = stmt2.executeQuery();
            
            while(rs.next()){
            Refund r = new Refund();
            r.setRefundID(rs.getString("refundID"));
            r.setPayID(rs.getString("payID"));
            r.setMemID(rs.getString("memID"));
            r.setHp(rs.getString("Hp"));
            r.setRprice(rs.getDouble("rprice"));
            r.setStatus(rs.getString("status"));
                 
            refundarray.add(r);
    }
      
    return refundarray;
    
}

}
