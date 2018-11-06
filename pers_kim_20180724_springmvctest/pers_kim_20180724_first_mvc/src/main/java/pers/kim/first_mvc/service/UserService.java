package pers.kim.first_mvc.service;

import pers.kim.first_mvc.pojo.UserPojo;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public interface UserService {
    public int insertUser(UserPojo userPojo);
    public UserPojo findUser(UserPojo userPojo);
}
