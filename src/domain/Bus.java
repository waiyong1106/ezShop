package domain;

public class Bus {
    private String busID;
    private String busName;
    private int seat;
    private int vip;

    public Bus() {
    }

    public Bus(String busID, String busName, int seat, int vip) {
        this.busID = busID;
        this.busName = busName;
        this.seat = seat;
        this.vip = vip;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Bus{" + "busID=" + busID + ", busName=" + busName + ", seat=" + seat + ", vip=" + vip + '}';
    }
    
    
    
}
