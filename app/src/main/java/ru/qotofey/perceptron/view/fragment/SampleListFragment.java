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
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.api.QuestionsApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.net.rest.model.response.Question;
import ru.qotofey.perceptron.presenter.SampleListPresenter;
import ru.qotofey.perceptron.view.SampleListView;
import ru.qotofey.perceptron.view.adapter.SampleListAdapter;
import ru.qotofey.perceptron.view.adapter.modelholder.AbstractSampleModelHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleAnswerModelHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleQuestionModelHolder;


public class SampleListFragment extends Fragment implements SampleListView  {

    private static final String TAG = SampleListFragment.class.getName();

//    private SampleListPresenter mPresenter;

    @Inject
    AnswersApi mAnswersApi;
//    @Inject
//    QuestionsApi mQuestionsApi;
    @Inject
    SampleStorage mStorage;

    private RecyclerView mRecyclerView;
    private SampleListAdapter mAdapter;

    private ProgressBar mProgressBar;

    public SampleListFragment() {
        // Required empty public constructor
//        mPresenter = new SampleListPresenter();
//        mPresenter.setView(this);
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




    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAnswersApi.get().enqueue(new Callback<List<Answer>>() {
            @Override
            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                mStorage.insertAnswerList(response.body());

                List<SampleAnswerModelHolder> list = new ArrayList<>();
                for (Sample item : mStorage.getSampleList()) {
                    list.add(new SampleAnswerModelHolder(item.getAnswer()));
                }
                mAdapter.addItems(list);
            }

            @Override
            public void onFailure(Call<List<Answer>> call, Throwable t) {
                t.printStackTrace();
                Log.e(TAG, call.toString());
                Log.e(TAG, "???????????????");
            }
        });

//        mAnswersApi.getStr().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.e(TAG, response.toString());
//                Log.e(TAG, "!!!!!!!!!!!!!!!");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                t.printStackTrace();
//                Log.e(TAG, call.toString());
//                Log.e(TAG, "???????????????");
//            }
//        });

//        mAnswersApi.get().enqueue(new Callback<List<Answer>>() {
//            @Override
//            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
//                Log.i(TAG, "" + response.headers());
//
//                mStorage.insertAnswerList(response.body());
//
//                List<SampleAnswerModelHolder> list = new ArrayList<>();
//                for (Sample item : mStorage.getSampleList()) {
//                    list.add(new SampleAnswerModelHolder(item.getAnswer()));
//                }
////                List<SampleAnswerModelHolder> list = new ArrayList<>();
////                for (Answer item : response.body()) {
////                    list.add(new SampleAnswerModelHolder(item));
////                }
//                mAdapter.addItems(list);

//                Snackbar.make(getView(), "Count: " + response.body().size(), Snackbar.LENGTH_SHORT).show();
//                mQuestionsApi.get().enqueue(new Callback<List<Question>>() {
//                    @Override
//                    public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
//                        mStorage.insertQuestionList(response.body());
////                        List<SampleQuestionModelHolder> list = new ArrayList<>();
////                        for (Question item : response.body()) {
////                            list.add(new SampleQuestionModelHolder(item));
////                        }
////                        mAdapter.addItems(list);
//                        List<AbstractSampleModelHolder> list = new ArrayList<>();
//                        for (Sample item : mStorage.getSampleList()) {
//                            try {
//                                list.add(new SampleQuestionModelHolder(item.getFirstQuestion()));
//                                list.add(new SampleAnswerModelHolder(item.getAnswer()));
//                            } catch (NullPointerException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        mAdapter.addItems(list);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Question>> call, Throwable t) {
//
//                    }
//                });
//            }

//            @Override
//            public void onFailure(Call<List<Answer>> call, Throwable t) {
//                Log.e(TAG, "Bad!");
////                Snackbar.make(getView(), "Bad request!", Snackbar.LENGTH_SHORT).show();
//                t.printStackTrace();
//            }
//
//        });


    }

    @Override
    public void renderSampleList(List<Sample> sampleList) {
        List<AbstractSampleModelHolder> list = new ArrayList<>();
        for (Sample item : sampleList) {
            try {
                list.add(new SampleQuestionModelHolder(item.getFirstQuestion()));
                list.add(new SampleAnswerModelHolder(item.getAnswer()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        mAdapter.addItems(list);
    }

    @Override
    public void renderAnswerList(List<Answer> answers) {
        List<SampleAnswerModelHolder> list = new ArrayList<>();
        for (Answer item : answers) {
            try {
                list.add(new SampleAnswerModelHolder(item));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        mAdapter.addItems(list);
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
