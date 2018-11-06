package tdd_test;

import java.util.Arrays;
import java.util.List;

/**
 * Create on 8/23/2018
 *
 * @Author Kim
 */
public class Comparation {
    public static List<String> cal(String input) {
        if (input.length() == 2) {
            return Arrays.asList(input, input.substring(1, 2) + input.substring(0, 1));
        }
        return Arrays.asList(input);
    }
}
