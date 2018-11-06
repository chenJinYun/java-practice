package pers.kim.scanpackage.annotation;

import java.lang.annotation.*;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
    String name() default "";
}
