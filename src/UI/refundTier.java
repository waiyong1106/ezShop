package UI;

import JDBC.refundJDBC;
import domain.Refund;

public class refundTier {
    refundJDBC jdbc;
    
    refundTier() throws Exception{
        jdbc = new refundJDBC();
    }
    
    public String storeRefund(String payID,String memID,double rprice)throws Exception{
        Refund r = new Refund();
        r.setPayID(payID);
        r.setMemID(memID);
        r.setRprice(rprice);
        String newId = jdbc.getId();
        r.setRefundID(newId);
        r.setStatus("Not Claim");
        String hp = jdbc.getHp(memID);
        r.setHp(hp);
        
        boolean success = jdbc.storeRefund(r);
        if(success)
            return newId;
        else
            return null;
    }
    
    
    
    
}
