package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer = new Answer();

    @Test
    public void should_return_numList_when_in_right_place() {
        Answer answer1=answer.createAnswer("4 3 2 1 ");
        String result=answer1.toString();
        String expectedResult="4 3 2 1";
        assertEquals(expectedResult,result);
    }

//    @Test(expected=OutOfRangeAnswerException.class)
//    public void should_return_false_when_more_then_4_digits() throws OutOfRangeAnswerException {
//        Answer answer1=answer.createAnswer("4 3 2 1 5 ");
//        answer1.validate();
//    }


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
        int[] expectedResult=new int[]{2,0};
        assertArrayEquals(expectedResult,answer.check(answer1).getValue());
    }

    @Test
    public void should_return_record_when_answer_has_the_same_digit_in_different_position() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("3 5 1 2");
        int[] expectedResult = new int[]{0,3};
        assertArrayEquals(expectedResult,answer.check(answer1).getValue());
    }

    @Test
    public void should_return_12_when_answer_has_the_same_digit_in_both_sameAdifferent_position() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("1 5 4 3");
        int[] expectedResult = new int[]{1,2};
        assertArrayEquals(expectedResult,answer.check(answer1).getValue());
    }

    @Test
    public void should_return_21_when_answer_has_the_same_digit_in_both_sameAdifferent_position() {
        Answer answer1=new Answer().createAnswer("1 2 3 4 ");
        answer.setNumList("1 5 3 2");
        int[] expectedResult = new int[]{2,1};
        assertArrayEquals(expectedResult,answer.check(answer1).getValue());
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