package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 10:21 AM
 **/
@Component
@Aspect
public class ValidationInterceptor {

    @Autowired private Validator validator;

    @Around("execution(* controller.*.*(..))")
    public Object validator(ProceedingJoinPoint point) throws Throwable {

        Object[] args = point.getArgs();

        Set<ConstraintViolation<Object>> violations = new HashSet<>();
        for (Object arg: args) {
            violations.addAll(validator.validate(arg));
        }

        if (violations.size() > 0) {
            // error
            List<String> errors = new ArrayList<>();
            for (ConstraintViolation<Object> error: violations) {
                errors.add(error.getMessage());
            }
            return errors;
        }
        return point.proceed();
    }

}
