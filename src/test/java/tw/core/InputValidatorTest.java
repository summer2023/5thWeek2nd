package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator=new InputValidator();

    @Test
    public void should_return_false_when_input_unValidate() {
        String string1="123";
        assertFalse(inputValidator.validate(string1));

        String string2="1123";
        assertFalse(inputValidator.validate(string2));

        String string3="1234";
        assertTrue(inputValidator.validate(string3));
    }
}
