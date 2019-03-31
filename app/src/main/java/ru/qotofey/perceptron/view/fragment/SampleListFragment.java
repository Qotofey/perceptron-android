package ru.qotofey.perceptron.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.presenter.SampleListPresenter;
import ru.qotofey.perceptron.view.SampleListView;
import ru.qotofey.perceptron.view.adapter.SampleListAdapter;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleModelHolder;


public class SampleListFragment extends Fragment implements SampleListView  {

    private static final String TAG = SampleListFragment.class.getName();

    public interface SampleListListener {
        void onSampleClicked(final Sample sample);
    }

    private SampleListPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private SampleListAdapter mAdapter;

    private ProgressBar mProgressBar;

    private SampleListListener mSampleListListener;

    public SampleListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SampleListPresenter();
        mPresenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SampleListListener) {
            mSampleListListener = (SampleListListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSampleListListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProgressBar = getActivity().findViewById(R.id.progressBar);
        View view = inflater.inflate(R.layout.fragment_sample_list, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SampleListAdapter();
        mAdapter.onItemClickListener = mOnItemClickListener;
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.init();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void renderSampleList(List<Sample> sampleList) {
        List<SampleModelHolder> list = new ArrayList<>();
        for (Sample item : sampleList) {
            try {
                list.add(new SampleModelHolder(item));
                Log.i(TAG, "item rendered");
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

    private SampleListAdapter.OnItemClickListener mOnItemClickListener = new SampleListAdapter.OnItemClickListener() {
        @Override
        public void onUserItemClicked(Sample sample) {
            if (mPresenter != null && sample != null) {
                mPresenter.onUserClicked(sample);
            }
        }
    };

    @Override
    public void viewSample(Sample sample) {
        mSampleListListener.onSampleClicked(sample);
    }
}
