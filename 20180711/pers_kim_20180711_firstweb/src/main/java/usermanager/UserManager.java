package usermanager;

import datalist.User;

import java.util.List;

public interface UserManager {
    public int addUser(User user);
    public List<User> findAllUser();
}
