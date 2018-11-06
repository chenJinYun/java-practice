package pers.kim.administrator.service;

import pers.kim.administrator.pojo.User;

import java.util.List;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
public interface UserManager {
    public User addUser(User user);

    public List<User> findAllUser();
}
