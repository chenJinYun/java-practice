package constraint;

import annotation.Between;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 9:51 AM
 **/
public class BetweenConstraint implements ConstraintValidator<Between, Integer> {

    private int min;
    private int max;

    @Override
    public void initialize(Between between) {
        min = between.min();
        max = between.max();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer != null && integer >= min && integer <= max)
            return true;
        return false;
    }
}
