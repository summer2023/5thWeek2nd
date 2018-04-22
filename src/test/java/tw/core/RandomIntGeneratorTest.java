package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertEquals;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
 private RandomIntGenerator randomIntGenerator=new RandomIntGenerator();

    @Test
    public void should_generateNums_return_length_of_correct() {
        //String randomNumStr = randomIntGenerator.generateNums(3, 4);
        String randomNumStr = randomIntGenerator.generateNums(9, 4);
        assertEquals(7, randomNumStr.length());
    }
}