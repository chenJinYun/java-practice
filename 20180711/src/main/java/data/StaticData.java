package data;

import bean.User;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Create by StaticData on 7/11/2018
 */
public class StaticData {

    public static List<User> userList = new Vector<>();

    static {
        for (int i = 0; i < 10; i++) {
            userList.add(new User("name" + i, "password" + i, new Date(), "major" + i));
        }
    }
}
