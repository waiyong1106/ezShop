package domain;

public class Staff {
    private String staffID;
    private String staffName;
    private String hp;
    private String address;
    private String birth;
    private double salary;
    private String username;
    private String password;

    public Staff() {
    }

    public Staff(String staffID, String staffName, String hp, String address, String birth, double salary, String username, String password) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.hp = hp;
        this.address = address;
        this.birth = birth;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", staffName=" + staffName + ", hp=" + hp + ", address=" + address + ", birth=" + birth + ", salary=" + salary + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
