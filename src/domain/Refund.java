package domain;

public class Refund {
    private String refundID;
    private String payID;
    private String memID;
    private String hp;
    private double rprice;
    private String status;

    public Refund() {
    }

    public String getRefundID() {
        return refundID;
    }

    public void setRefundID(String refundID) {
        this.refundID = refundID;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Refund{" + "refundID=" + refundID + ", payID=" + payID + ", memID=" + memID + ", hp=" + hp + ", rprice=" + rprice + ", status=" + status + '}';
    }
    
    
}
