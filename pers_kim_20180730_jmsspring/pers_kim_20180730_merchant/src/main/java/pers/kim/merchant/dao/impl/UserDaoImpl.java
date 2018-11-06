package pers.kim.merchant.dao.impl;

import pers.kim.merchant.dao.UserDao;
import org.springframework.stereotype.Repository;
import pers.kim.merchant.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(name = "em")
    private EntityManager manager;

    @Override
    public User addUser(User user) {
        manager.persist(user);
        return user;
    }
}
