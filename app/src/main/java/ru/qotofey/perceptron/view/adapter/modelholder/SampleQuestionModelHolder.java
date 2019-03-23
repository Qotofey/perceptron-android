package ru.qotofey.perceptron.view.adapter.modelholder;

import android.view.View;

import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleQuestionViewHolder;

public class SampleQuestionModelHolder extends AbstractSampleModelHolder {

    private long mId;
    private String mText;

    public SampleQuestionModelHolder(long id, String text) {
        mId = id;
        mText = text;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ItemSampleAnswer;
    }

    @Override
    protected AbstractSampleViewHolder onCreateViewHolder(View view) {
        return new SampleQuestionViewHolder(view);
    }

    public String getText() {
        return mText;
    }


}
