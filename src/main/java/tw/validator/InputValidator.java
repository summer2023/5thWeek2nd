package tw.validator;

import org.apache.commons.math3.geometry.Space;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

/**
 * Created by jxzhong on 2017/5/18.
 */
public class InputValidator {
    public static final String SPACE=" ";
    private int NUM_COUNT=4;
    public Boolean validate(String numStr) {
        return numStr.trim().length() == 7 && NUM_COUNT == Arrays.stream(numStr.split(SPACE))
                .map(num -> parseInt(num))
                .distinct()
                .filter(num -> num < 10).count();
    }
}
