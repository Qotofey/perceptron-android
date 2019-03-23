package ru.qotofey.perceptron.view.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleQuestionModelHolder;

public class SampleQuestionViewHolder extends AbstractSampleViewHolder<SampleQuestionModelHolder> {

    private TextView mQuestionTextView;

    public SampleQuestionViewHolder(View itemView) {
        super(itemView);
        mQuestionTextView = itemView.findViewById(R.id.questionTextView);
    }

    @Override
    public void bind(SampleQuestionModelHolder sampleQuestionModelHolder) {
        mQuestionTextView.setText(sampleQuestionModelHolder.getText());
    }

    @Override
    public void unbind() {
        mQuestionTextView.setText(null);
    }
}
