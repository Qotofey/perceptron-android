package ru.qotofey.perceptron.view.adapter.modelholder;

import android.view.View;

import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleAnswerViewHolder;

public class SampleAnswerModelHolder extends AbstractSampleModelHolder {

    private String mText;

    public SampleAnswerModelHolder(Answer answerItem) {
        mText = answerItem.text;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ItemSampleAnswer;
    }

    @Override
    protected AbstractSampleViewHolder onCreateViewHolder(View view) {
        return new SampleAnswerViewHolder(view);
    }

    public String getText() {
        return mText;
    }
}
