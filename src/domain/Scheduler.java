package domain;

public class Scheduler {
    private String scheID;
    private String scheDate;
    private String dest;
    private String departure;
    private String busID;
    private String driverID;
    private String normal;
    private String vip;

    public Scheduler() {
    }

    public Scheduler(String scheID, String scheDate, String dest, String departure, String busID, String driverID, String normal, String vip) {
        this.scheID = scheID;
        this.scheDate = scheDate;
        this.dest = dest;
        this.departure = departure;
        this.busID = busID;
        this.driverID = driverID;
        this.normal = normal;
        this.vip = vip;
    }

    public String getScheID() {
        return scheID;
    }

    public void setScheID(String scheID) {
        this.scheID = scheID;
    }

    public String getScheDate() {
        return scheDate;
    }

    public void setScheDate(String scheDate) {
        this.scheDate = scheDate;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Scheduler{" + "scheID=" + scheID + ", scheDate=" + scheDate + ", dest=" + dest + ", departure=" + departure + ", busID=" + busID + ", driverID=" + driverID + ", normal=" + normal + ", vip=" + vip + '}';
    }
    
    
}
