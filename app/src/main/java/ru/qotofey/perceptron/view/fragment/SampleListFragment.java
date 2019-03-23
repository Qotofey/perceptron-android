package ru.qotofey.perceptron.view.fragment;

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

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.presenter.SampleListPresenter;
import ru.qotofey.perceptron.view.SampleListView;
import ru.qotofey.perceptron.view.adapter.SampleListAdapter;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleAnswerModelHolder;


public class SampleListFragment extends Fragment implements SampleListView  {

    private static final String TAG = SampleListFragment.class.getName();

    @Inject
    AnswersApi mAnswersApi;

    private SampleListPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private SampleListAdapter mAdapter;

    private ProgressBar mProgressBar;

    public SampleListFragment() {
        // Required empty public constructor
        mPresenter = new SampleListPresenter();
        mPresenter.setView(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);

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
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.init();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAnswersApi.get().enqueue(new Callback<List<Answer>>() {
            @Override
            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                Log.i(TAG, "" + response.headers());

                List<SampleAnswerModelHolder> list = new ArrayList<>();
                for (Answer item : response.body()) {
                    list.add(new SampleAnswerModelHolder(item));
                }
                mAdapter.addItems(list);

//                Snackbar.make(getView(), "Count: " + response.body().size(), Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Answer>> call, Throwable t) {
                Log.e(TAG, "Bad!");
//                Snackbar.make(getView(), "Bad request!", Snackbar.LENGTH_SHORT).show();
            }

        });


    }

    @Override
    public void showLoading() {
//        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
//        mProgressBar.setVisibility(View.GONE);
    }

}
