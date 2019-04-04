package ru.qotofey.perceptron.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.presenter.SampleNewPresenter;
import ru.qotofey.perceptron.view.SampleNewView;

public class SampleNewFragment extends BaseFragment implements SampleNewView {

    private SampleNewPresenter mPresenter;

    private ProgressBar mProgressBar;
    private EditText mAnswerEditText;
    private EditText mQuestionEditText;
    private Button mCreateSampleButton;
    private Button mClearSampleButton;

    public SampleNewFragment() {
        App.getComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SampleNewPresenter();
        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProgressBar = getActivity().findViewById(R.id.progressBar);
        View view = inflater.inflate(R.layout.fragment_sample_new, container, false);

        mAnswerEditText = view.findViewById(R.id.answerEditText);
        mQuestionEditText = view.findViewById(R.id.questionEditText);

        mCreateSampleButton = view.findViewById(R.id.createSampleButton);
        mClearSampleButton = view.findViewById(R.id.clearSampleButton);

        mCreateSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.saveDataToNet(
                        mAnswerEditText.getText().toString(),
                        mQuestionEditText.getText().toString()
                );
            }
        });

        mClearSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionEditText.setText("");
                mAnswerEditText.setText("");
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void enableButtons() {
        mCreateSampleButton.setEnabled(true);
        mClearSampleButton.setEnabled(true);
    }

    @Override
    public void disableButtons() {
        mCreateSampleButton.setEnabled(false);
        mClearSampleButton.setEnabled(false);
    }
}
