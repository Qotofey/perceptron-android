package ru.qotofey.perceptron.view.adapter.modelholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleViewHolder;

public class SampleModelHolder {

    private Sample mSample;

    public SampleModelHolder(Sample sampleItem) {
        mSample = sampleItem;
    }

    protected SampleViewHolder onCreateViewHolder(View view) {
        return new SampleViewHolder(view);
    }

    public SampleViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_sample, parent, false)
        );
    }

    public Sample getSample() {
        return mSample;
    }
}
