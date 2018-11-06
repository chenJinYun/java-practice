package testUser;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.kim.merchant.pojo.User;
import pers.kim.merchant.service.UserManager;

import java.util.Date;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
public class TestUser {
    private static ApplicationContext context;
    @BeforeClass
    public static void init(){
        context=new ClassPathXmlApplicationContext("classpath:spring/*.xml");
    }

    @Test
    public void testAddUser() {
        User u=new User("kim","男",new Date(),"11.png");
        UserManager userManager=context.getBean(UserManager.class);
        User u1=userManager.addUser(u);
        Assert.assertTrue(u1!=null);
    }
}
