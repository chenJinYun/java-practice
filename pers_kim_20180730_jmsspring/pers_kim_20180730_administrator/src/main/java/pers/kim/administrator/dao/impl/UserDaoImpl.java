package pers.kim.administrator.dao.impl;

import pers.kim.administrator.dao.UserDao;
import org.springframework.stereotype.Repository;
import pers.kim.administrator.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public List<User> findAllUser() {
        String jpql="from pers.kim.administrator.pojo.User";
        return manager.createQuery(jpql).getResultList();
    }
}
