package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void should_return_numList_when_in_right_place() {
        Answer answer1=answer.createAnswer("4 3 2 1 ");
        String result=answer1.toString();
        String expectedResult="4 3 2 1 ";
        assertEquals(expectedResult,result);
    }

    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_false_when_more_then_4_digits() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("4 3 2 1 5 ");
        answer1.validate();
    }


    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_WrongInput_when_less_then_4_digits() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("1 2 1 2 ");
        answer1.validate();
    }

    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_WrongInput_when_has_repeat_digit() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("12");
        answer1.validate();
    }

    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_WrongInput_when_has_digit_bigger_than_maxint() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("1 2 23 4 5");
        answer1.validate();
    }
}