package tw.core;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Answer {

    public static final String SPACE = " ";
    private List<String> numList;

    public void setNumList(String NumStr) {
        this.numList = Arrays.stream(NumStr.split(SPACE)).collect(Collectors.toList());
    }

    public static Answer createAnswer(String inputStr) {
        Answer answer = new Answer();
        answer.setNumList(inputStr);
        return answer;
    }

    public void validate() throws OutOfRangeAnswerException {
        long validatedNum = numList.stream()
                .map(num -> parseInt(num))
                .distinct()
                .filter(num -> num < 10).count();
        if (validatedNum < numList.size()) {
            throw new OutOfRangeAnswerException("Answer format is incorrect");
        }
    }

    public Record check(Answer inputAnswer) {
        Record record = new Record();
        this.numList.stream().filter(num->inputAnswer.getIndexOfNum(num) != -1).forEach(num -> {
                if (inputAnswer.getIndexOfNum(num) == getIndexOfNum(num)) {
                    record.increaseCurrentNum();
                } else {
                    record.increaseIncludeOnlyNum();
                }
        });
        return record;
    }

    public int getIndexOfNum(String num) {
        return this.numList.indexOf(num);
    }

    @Override
    public String toString() {
        return String.join(SPACE, numList);
    }

    public List<String> getNumList() {
        return this.numList;
    }
}
