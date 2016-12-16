package domain;

public class Member {
    private String memID;
    private String memName;
    private String gender;
    private String hp;
    private String address;
    private String birth;
    private String username;
    private String password;

    public Member() {
    }

    public Member(String memID, String memName, String gender, String hp, String address, String birth, String username, String password) {
        this.memID = memID;
        this.memName = memName;
        this.gender = gender;
        this.hp = hp;
        this.address = address;
        this.birth = birth;
        this.username = username;
        this.password = password;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "Member{" + "memID=" + memID + ", memName=" + memName + ", gender=" + gender + ", hp=" + hp + ", address=" + address + ", birth=" + birth + ", username=" + username + ", password=" + password + '}';
    }
        
}
