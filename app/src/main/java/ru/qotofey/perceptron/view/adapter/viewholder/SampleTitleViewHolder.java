package ru.qotofey.perceptron.view.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleTitleModelHolder;

public class SampleTitleViewHolder extends AbstractSampleViewHolder<SampleTitleModelHolder> {

    private TextView mTitleTextView;

    public SampleTitleViewHolder(View itemView) {
        super(itemView);
        mTitleTextView = itemView.findViewById(R.id.titleTextView);
    }

    @Override
    public void bind(SampleTitleModelHolder item) {
        mTitleTextView.setText(item.getTitle());
    }

    @Override
    public void unbind() {
        mTitleTextView.setText(null);
    }
}
