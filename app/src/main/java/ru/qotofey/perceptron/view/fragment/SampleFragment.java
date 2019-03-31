package ru.qotofey.perceptron.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.presenter.SamplePresenter;
import ru.qotofey.perceptron.view.SampleView;
import ru.qotofey.perceptron.view.activity.SampleActivity;
import ru.qotofey.perceptron.view.adapter.SampleAdapter;

public class SampleFragment extends BaseFragment implements SampleView {

    private SamplePresenter mPresenter;

    private RecyclerView mRecyclerView;
    private SampleAdapter mAdapter;

    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SamplePresenter();
        mPresenter.setView(this);
        UUID sampleId = (UUID) getActivity().getIntent().getSerializableExtra(SampleActivity.EXTRA_SAMPLE_ID);
        mPresenter.setModel(sampleId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
//        mAnswerBodyTextView = view.findViewById(R.id.answerBodyTextView);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void renderSample(Sample sample) {
//        mAnswerBodyTextView.setText(sample.getAnswer().text);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
