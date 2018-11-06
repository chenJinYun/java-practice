package datalist;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class StaticData {
    public static List<User> users=new Vector<>();
    static{
        for (int i = 0; i < 5; i++) {
            users.add(new User("username"+i,"pwd"+i,"major"+i,new Date()));
        }
    }
}
