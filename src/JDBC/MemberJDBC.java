package JDBC;

import domain.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberJDBC {
    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    
    public MemberJDBC() throws SQLException{    
        String url = "jdbc:mysql://localhost:3306/easyexpress";
        String username = "root";
        String password="";
        con = DriverManager.getConnection(url,username,password);
        stmt= con.createStatement();            
    }
    
    public String getId()throws SQLException{
        String m_id="M";
        
        String sql = "select MAX(memID) as highestId from member";
        
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
           newId =m_id +iid;
           } 
        }
                
        if (!found)
            newId="M10001";
        return newId;   //refactoring
    }
    
    public boolean register(Member m) throws SQLException{
              String sql2 = "insert into member(memID,memName,gender,hp,address,birth,username,password) values(?,?,?,?,?,?,?,?)";
              stmt2 = con.prepareStatement(sql2);
              stmt2.setString(1,m.getMemID());
              stmt2.setString(2,m.getMemName());
              stmt2.setString(3,m.getGender());
              stmt2.setString(4,m.getHp());
              stmt2.setString(5,m.getAddress());
              stmt2.setString(6,m.getBirth());
              stmt2.setString(7,m.getUsername());
              stmt2.setString(8,m.getPassword());
                            
              int result= stmt2.executeUpdate();
              
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public boolean memlog(Member m)throws SQLException{
        String sql3 = "select * from member where username=? AND password=?";
        stmt2 = con.prepareStatement(sql3);
        stmt2.setString(1,m.getUsername());
        stmt2.setString(2,m.getPassword());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            m.setMemID(rs.getString("memID"));
            m.setMemName(rs.getString("memName"));
            m.setAddress(rs.getString("address"));
            m.setBirth(rs.getString("birth"));
            m.setHp(rs.getString("hp"));
            m.setGender(rs.getString("gender"));
        }
        return true;
                
    }
    
    public Member passRecover(Member m)throws SQLException{
        String sql4 = "select * from member where username=? AND hp=?";
        stmt2 = con.prepareStatement(sql4);
        stmt2.setString(1,m.getUsername());
        stmt2.setString(2,m.getHp());
        //compare the usersname and password success
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            m.setMemID(rs.getString("memID"));
            m.setMemName(rs.getString("memName"));
            m.setAddress(rs.getString("address"));
            m.setBirth(rs.getString("birth"));
            m.setGender(rs.getString("gender"));
            m.setPassword(rs.getString("password"));
        }
        return m;
                
    }
    
    public Member retrieveMem(Member m)throws SQLException{
        String sql5 = "select * from member where memID=?";
        stmt2 = con.prepareStatement(sql5);
        stmt2.setString(1,m.getMemID());
        
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            m.setMemName(rs.getString("memName"));
            m.setAddress(rs.getString("address"));
            m.setBirth(rs.getString("birth"));
            m.setGender(rs.getString("gender"));
            m.setPassword(rs.getString("password"));
            m.setHp(rs.getString("hp"));
            m.setUsername(rs.getString("username"));
        }
        return m;
                
    }
    
    public boolean updateMem(Member m) throws SQLException{
        String sql6 = "update member set hp='"+m.getHp()+"',address='"+m.getAddress()+"'where memID='"+m.getMemID()+"'";
        int result = stmt.executeUpdate(sql6);
        
        if (result > 0)
            return true;
        else
            return false;
    }
}
