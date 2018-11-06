package pers.kim.merchant.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.kim.merchant.dao.UserDao;
import pers.kim.merchant.jms.Sender;
import pers.kim.merchant.pojo.User;
import pers.kim.merchant.service.UserManager;


/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@Service
public class UserMangerImpl implements UserManager {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Sender sender;

    @Transactional
    @Override
    public User addUser(User user) {
        sender.send(user);
        return userDao.addUser(user);
    }
}
