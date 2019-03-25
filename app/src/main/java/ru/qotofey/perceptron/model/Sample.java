package ru.qotofey.perceptron.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public class Sample {

    private UUID mId;
    private Answer mAnswer;
    private List<Question> mQuestionList;

    public Sample(UUID id, Answer answer) {
        mId = id;
        mAnswer = answer;
        mQuestionList = new ArrayList<>();
    }

    public Sample(Answer answer) {
        this(UUID.randomUUID(), answer);
    }

    public Sample distribute(List<Question> questionList) {
        for (Question question : questionList) {
            if (mAnswer.id.equals(question.answerId)) {
                mQuestionList.add(question);
            }
        }
        return this;
    }

    public UUID getId() {
        return mId;
    }

    public Answer getAnswer() {
        return mAnswer;
    }

    public Sample setAnswer(Answer answer) {
        mAnswer = answer;
        return this;
    }

    public Question getFirstQuestion() {
        return mQuestionList.get(0);
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }



}
