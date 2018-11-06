package tddtest;

import org.junit.Assert;
import org.junit.Test;
import tdd_test.Comparation;

import java.util.Arrays;
import java.util.List;

/**
 * Create on 8/23/2018
 *
 * @Author Kim
 */
public class Test_TDD {
    @Test
    public void should_return_a_when_input_a() {
//        Given
        String input = "a";

//        When
        List<String> output = Comparation.cal(input);

//        Then
        Assert.assertEquals(Arrays.asList("a"), output);
    }

    @Test
    public void should_return_ab_ba_when_input_ab() {
//        Given
        String input = "ab";

//        When
        List<String> output = Comparation.cal(input);

//        Then
        Assert.assertEquals(Arrays.asList("ab", "ba"), output);
    }

    @Test

    public void should_return_list_when_input() {
    }
}
