package ru.qotofey.perceptron.view.adapter.modelholder;

import android.view.View;

import ru.qotofey.perceptron.net.rest.model.response.Question;
import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleQuestionViewHolder;

public class SampleQuestionModelHolder extends AbstractSampleModelHolder {

    private long mId;
    private String mText;

    public SampleQuestionModelHolder(Question question) {
        mId = question.id;
        mText = question.text;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ItemSampleQuestion;
    }

    @Override
    protected AbstractSampleViewHolder onCreateViewHolder(View view) {
        return new SampleQuestionViewHolder(view);
    }

    public String getText() {
        return mText;
    }


}
