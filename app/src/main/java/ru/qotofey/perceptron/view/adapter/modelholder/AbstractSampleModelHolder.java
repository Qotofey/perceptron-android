package ru.qotofey.perceptron.view.adapter.modelholder;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;

public abstract class AbstractSampleModelHolder {

    public abstract LayoutTypes getType();

    protected abstract AbstractSampleViewHolder onCreateViewHolder(View view);

    public AbstractSampleViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(getType().getResId(), parent, false)
        );
    }

    public enum LayoutTypes {

        ItemSampleAnswer(R.layout.item_sample_answer),
        ItemSampleQuestion(R.layout.item_sample_question);

        private final int mId;

        LayoutTypes(int resId) {
            mId = resId;
        }

        @LayoutRes
        public int getResId() {
            return mId;
        }
    }

}
