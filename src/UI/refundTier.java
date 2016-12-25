package UI;

import JDBC.refundJDBC;
import domain.Refund;
import java.util.ArrayList;

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
    
    public ArrayList<Refund> retrieveRefund() throws Exception{
        ArrayList<Refund> refundarray  = new ArrayList<Refund>();
        
        try{
            refundarray = jdbc.retrieveRefund();
         }catch(Exception ex){
             throw new Exception("No Record");
         } 
        return refundarray;
    }
    
    
    
}
