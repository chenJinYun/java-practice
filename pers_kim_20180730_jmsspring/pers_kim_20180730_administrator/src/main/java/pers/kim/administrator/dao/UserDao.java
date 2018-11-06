package pers.kim.administrator.dao;

import pers.kim.administrator.pojo.User;

import java.util.List;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
public interface UserDao {
    public User addUser(User user);

    public List<User> findAllUser();
}
