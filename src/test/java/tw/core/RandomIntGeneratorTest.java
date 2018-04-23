package tw.core;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private RandomIntGenerator randomIntGenerator = new RandomIntGenerator();

    @Test
    public void should_throw_IllegalArgumentException_when_generate_unformat_digit(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Can't ask for more numbers than are available");
        randomIntGenerator.generateNums(3,4);
    }

    @Test
    public void should_generateNums_return_length_of_correct() {
        String randomNumStr = randomIntGenerator.generateNums(9, 4);
        assertEquals(7, randomNumStr.length());
    }

    @Test
    public void should_each_generate_number_less_than_digitmax() {
        String generateNums = randomIntGenerator.generateNums(9, 4);
        assertTrue(Arrays.stream(generateNums.split(" ")).allMatch(item ->  Integer.parseInt(item) < 9));
    }

    @Test
    public void should_each_generate_number_be_different() {
        String generateNums = randomIntGenerator.generateNums(9, 4);
        assertEquals(4, Arrays.stream(generateNums.split(" ")).distinct().count());
    }
}