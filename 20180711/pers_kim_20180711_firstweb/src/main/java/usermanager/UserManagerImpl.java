package usermanager;

import datalist.StaticData;
import datalist.User;

import java.util.List;

public class UserManagerImpl implements UserManager{
    @Override
    public int addUser(User user) {
        if(user==null) return 0;
        StaticData.users.add(user);
        return 1;
    }

    @Override
    public List<User> findAllUser() {
        return StaticData.users;
    }
}
