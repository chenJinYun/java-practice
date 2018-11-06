package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by User on 7/11/2018
 */
public class User implements Serializable {

    private String name;

    private String passWord;

    private Date birth;

    private String major;

    public User() {
    }

    public User(String name, String passWord, Date birth, String major) {
        this.name = name;
        this.passWord = passWord;
        this.birth = birth;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
