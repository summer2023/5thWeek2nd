package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

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
    public void should_return_false_when_less_then_4_digits() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("1 2 1 2 ");
        answer1.validate();
    }

    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_false_when_has_repeat_digit() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("12");
        answer1.validate();
    }

    @Test(expected=OutOfRangeAnswerException.class)
    public void should_return_false_when_has_digit_bigger_than_maxint() throws OutOfRangeAnswerException {
        Answer answer1=answer.createAnswer("1 2 23 4 5");
        answer1.validate();
    }

    @Test
    public void should_return_record_when_answer_has_the_same_digit_in_same_position() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("1 5 3 8");
        Record expectedResult=new Record();
        expectedResult.increaseCurrentNum();
        expectedResult.increaseCurrentNum();
        Record result=answer.check(answer1);
        assertEquals(expectedResult,result);
    }

    @Test
    public void should_return_record_when_answer_has_the_same_digit_in_different_position() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("3 5 1 8");
        Record expectedResult=new Record();
        expectedResult.increaseIncludeOnlyNum();
        expectedResult.increaseIncludeOnlyNum();
        Record result=answer.check(answer1);
        assertEquals(expectedResult,result);
    }

    @Test
    public void should_return_record_when_answer_does_not_has_same_digit() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("5 6 7 8 ");
        Record expectedResult=new Record();
        Record result=answer.check(answer1);
        assertEquals(expectedResult,result);
    }
}