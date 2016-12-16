package domain;

public class Seat {
    private String scheID;
    private int normal;
    private int vip;
    private double priceN;
    private double priceVip;

    public Seat() {
    }

    public Seat(String scheID, int normal, int vip, double priceN, double priceVip) {
        this.scheID = scheID;
        this.normal = normal;
        this.vip = vip;
        this.priceN = priceN;
        this.priceVip = priceVip;
    }

    public String getScheID() {
        return scheID;
    }

    public void setScheID(String scheID) {
        this.scheID = scheID;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public double getPriceN() {
        return priceN;
    }

    public void setPriceN(double priceN) {
        this.priceN = priceN;
    }

    public double getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(double priceVip) {
        this.priceVip = priceVip;
    }

    @Override
    public String toString() {
        return "Seat{" + "scheID=" + scheID + ", normal=" + normal + ", vip=" + vip + ", priceN=" + priceN + ", priceVip=" + priceVip + '}';
    }
    
    
    
}
