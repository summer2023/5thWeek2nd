package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer = new Answer();

    @Test
    public void should_return_Answer_when_input_String() {
        Answer answer1=answer.createAnswer("1234");
        List<String> result=answer1.getNumList();
        String string="1234";
        Answer answer2=new Answer();
        answer2.setNumList(Arrays.stream(string.split(" ")).collect(Collectors.toList()));
        List<String> expectedResult=answer2.getNumList();

        assertEquals(result,expectedResult);
    }

    @Test
    public void should_return_WrongInput_when_input_unformat() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("1212");
        Answer answer2=answer.createAnswer("12");
//        answer1.validate();
//        answer2.validate();
    }

    @Test
    public void should_return_numList_when_toString() {
        Answer answer1=answer.createAnswer("4321");
        String result=answer1.toString();
        String expectedResult="4321";
        assertEquals(expectedResult,result);
    }
}