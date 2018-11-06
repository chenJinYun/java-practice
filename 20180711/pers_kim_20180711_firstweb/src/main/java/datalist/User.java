package datalist;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String username;
    private String pwd;
    private String major;
    private Date birth;

    public User() {
    }

    public User(String username, String pwd, String major, Date birth) {
        this.username = username;
        this.pwd = pwd;
        this.major = major;
        this.birth = birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
