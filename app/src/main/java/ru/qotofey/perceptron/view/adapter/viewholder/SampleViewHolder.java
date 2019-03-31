package ru.qotofey.perceptron.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleModelHolder;

public class SampleViewHolder extends RecyclerView.ViewHolder {

    private TextView mAnswerTextView;
    private TextView mQuestionTextView;

    public SampleViewHolder(View itemView) {
        super(itemView);
        mAnswerTextView = itemView.findViewById(R.id.answerTextView);
        mQuestionTextView = itemView.findViewById(R.id.questionTextView);

    }

    public void bind(SampleModelHolder item) {
        mAnswerTextView.setText(item.getSample().getAnswer().text);
        mQuestionTextView.setText(item.getSample().getFirstQuestion().text);
    }

    public void unbind() {
        mAnswerTextView.setText(null);
        mQuestionTextView.setText(null);
    }
}
