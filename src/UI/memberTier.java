package UI;

import JDBC.MemberJDBC;
import domain.Member;

public class memberTier {
    MemberJDBC jdbc;
    
    memberTier() throws Exception{
        jdbc = new MemberJDBC();
    }
    
    public String register(String name,String gender,String hp,String address,String birth,String username,String password)throws Exception{
        
        String newId = jdbc.getId();
                
        Member m = new Member();
        m.setMemID(newId);
        m.setAddress(address);
        m.setBirth(birth);
        m.setGender(gender);
        m.setHp(hp);
        m.setMemName(name);
        m.setUsername(username);
        m.setPassword(password);
        
        String ok = "success";
        
        boolean success = jdbc.register(m);
        if(success)
            return ok;
        else
            return null;
    }
    
    public String memlog(Member m)throws Exception{
        
        boolean success = jdbc.memlog(m);
        System.out.println(m.getMemID());
        if(success)
            return m.getMemID();
        else
            return null;
        
    }
    
    public Member passRecover(String username,String hp)throws Exception{
        
        Member m = new Member();
        m.setHp(hp);
        m.setUsername(username);
        m = jdbc.passRecover(m);
        
        return m;
    }
    
    public Member retrieveMem(String MemID)throws Exception{
        
        Member m = new Member();
        m.setMemID(MemID);
        m = jdbc.retrieveMem(m);
        
        return m;
    }
    
    public boolean updateMem(String memID,String name,String gender,String hp,String address,String birth)throws Exception{
        
        Member m = new Member();
        m.setMemID(memID);
        m.setMemName(name);
        m.setGender(gender);
        m.setHp(hp);
        m.setBirth(birth);
        m.setAddress(address);
        
        boolean success = jdbc.updateMem(m);
        
        if(success)
            return true;
        else
            return false;
    }
    
    
    
    
}
