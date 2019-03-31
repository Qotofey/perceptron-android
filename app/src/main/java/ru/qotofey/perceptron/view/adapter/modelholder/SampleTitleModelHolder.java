package ru.qotofey.perceptron.view.adapter.modelholder;

import android.view.View;

import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleTitleViewHolder;

public class SampleTitleModelHolder extends AbstractSampleModelHolder {

    private String mTitle;

    public SampleTitleModelHolder(String title) {
        mTitle = title;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ItemTitle;
    }

    @Override
    protected AbstractSampleViewHolder onCreateViewHolder(View view) {
        return new SampleTitleViewHolder(view);
    }

    public String getTitle() {
        return mTitle;
    }
}
