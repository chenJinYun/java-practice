package pojo;

import annotation.Between;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 9:33 AM
 **/
public class User {

    @NotEmpty(message = "{user.username}")
    private String username;

    @Pattern(regexp = "[0-9a-zA-Z_]{6,10}")
    private String password;

    @Between(min = 0, max = 100, message = "非法年龄")
    private int age;

    @Email
    private String email;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
