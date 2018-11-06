package pers.kim.first_mvc.pojo;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public class UserPojo {
    private String name;
    private String password;
    private String rpassword;
    private int age;

    public UserPojo() {
    }

    public UserPojo(String name, String password, String rpassword, int age) {
        this.name = name;
        this.password = password;
        this.rpassword = rpassword;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
