package pers.kim.administrator.service.impl;

import pers.kim.administrator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.kim.administrator.pojo.User;
import pers.kim.administrator.service.UserManager;

import java.util.List;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@Service
public class UserMangerImpl implements UserManager {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
