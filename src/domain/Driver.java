/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Tsang
 */
public class Driver {
        
        private String driverID;
        private String driverName;
        private int hp;
        private String address;
        private String birth;
        private double salary;
        private String busID;

public Driver(){}
    public Driver(String driverID, String driverName, int hp, String address, String birth, double salary, String busID) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.hp = hp;
        this.address = address;
        this.birth = birth;
        this.salary = salary;
        this.busID = busID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverID=" + driverID + ", driverName=" + driverName + ", hp=" + hp + ", address=" + address + ", birth=" + birth + ", salary=" + salary + ", busID=" + busID + '}';
    }
        
   
}
