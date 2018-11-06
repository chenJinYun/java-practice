package manager;

import bean.User;
import data.StaticData;

import java.util.List;

/**
 * Create by UserManagerImpl on 7/11/2018
 */
public class UserManagerImpl implements UserManager{
    @Override
    public int addUser(User user) {
       if (user == null)
            return 0;
        StaticData.userList.add(user);
        return 1;
    }

    @Override
    public List<User> findAllUsers() {
        return StaticData.userList;
    }
}
