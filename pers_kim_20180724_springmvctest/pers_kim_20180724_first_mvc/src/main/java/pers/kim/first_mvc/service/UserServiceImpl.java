package pers.kim.first_mvc.service;

import pers.kim.first_mvc.dao.UserDao;
import pers.kim.first_mvc.pojo.UserPojo;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public class UserServiceImpl implements UserService{

    @Override
    public int insertUser(UserPojo userPojo) {
        int i=UserDao.insertUser(userPojo);
        return i;
    }

    @Override
    public UserPojo findUser(UserPojo userPojo) {
        UserPojo user=UserDao.findUser(userPojo);
        return user;
    }
}
