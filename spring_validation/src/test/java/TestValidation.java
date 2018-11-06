import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 9:33 AM
 **/
public class TestValidation {

    private static Validator validator;

    @BeforeClass
    public static void init() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testUsername() {
        User user = new User("", "1234567");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
//        Assert.assertEquals("用户名不能为空", violations.iterator().next().getMessage()); // 因多语言，Test依赖Spring环境， 详见Spring Test
    }

    @Test
    public void testAge() {
        User user = new User("123", "1234567", 101);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("非法年龄", violations.iterator().next().getMessage());
    }

}
