package ru.qotofey.perceptron.view.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleAnswerModelHolder;

public class SampleAnswerViewHolder extends AbstractSampleViewHolder<SampleAnswerModelHolder> {

    private TextView mAnswerTextView;

    public SampleAnswerViewHolder(View itemView) {
        super(itemView);
        mAnswerTextView = (TextView) itemView.findViewById(R.id.answerTextView);
    }

    @Override
    public void bind(SampleAnswerModelHolder sampleAnswerModelHolder) {
        mAnswerTextView.setText(sampleAnswerModelHolder.getText());
    }

    @Override
    public void unbind() {
        mAnswerTextView.setText(null);
    }
}
