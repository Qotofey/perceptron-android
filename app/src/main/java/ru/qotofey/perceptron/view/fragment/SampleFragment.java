package ru.qotofey.perceptron.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.net.rest.model.response.Question;
import ru.qotofey.perceptron.presenter.SamplePresenter;
import ru.qotofey.perceptron.view.SampleView;
import ru.qotofey.perceptron.view.activity.SampleActivity;
import ru.qotofey.perceptron.view.adapter.SampleAdapter;
import ru.qotofey.perceptron.view.adapter.modelholder.AbstractSampleModelHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleAnswerModelHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleQuestionModelHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleTitleModelHolder;

public class SampleFragment extends BaseFragment implements SampleView {

    private SamplePresenter mPresenter;

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private SampleAdapter mAdapter;
    private FloatingActionButton mDeleteSampleFab;

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
        mProgressBar = getActivity().findViewById(R.id.progressBar);
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        mDeleteSampleFab = view.findViewById(R.id.fab);
        mRecyclerView = view.findViewById(R.id.recyclerView);

        mDeleteSampleFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.deleteSample();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SampleAdapter();
        mRecyclerView.setAdapter(mAdapter);
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
        List<AbstractSampleModelHolder> list = new ArrayList<>();
        list.add(new SampleTitleModelHolder("Ответ"));
        list.add(new SampleAnswerModelHolder(sample.getAnswer()));
        list.add(new SampleTitleModelHolder("Вопросы"));
        for (Question item : sample.getQuestionList()) {
            try {
                list.add(new SampleQuestionModelHolder(item));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        mAdapter.setItems(list);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
}
