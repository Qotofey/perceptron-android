package ru.qotofey.perceptron.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.api.QuestionsApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.net.rest.model.response.Question;
import ru.qotofey.perceptron.view.SampleListView;

public class SampleListPresenter extends BasePresenter {

    private SampleListView mView;

    @Inject SampleStorage mStorage;
    @Inject AnswersApi mAnswersApi;
    @Inject QuestionsApi mQuestionsApi;

    public SampleListPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleListView view) {
        mView = view;
    }

    public void init() {
        mView.showLoading();
        loadDataFromDB();
        loadDataFromNet();
    }

    private void loadDataFromDB() {

    }



    //порядок загрузки может быть случайным, требуется явно указать последовательность загрузки
    private void loadDataFromNet() {
        mAnswersApi.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(mLoadQuestionListAction)
                .subscribe(mStorage.answerListObserver);
    }

    private Action mLoadQuestionListAction = new Action() {
        @Override
        public void run() throws Exception {
            mQuestionsApi.getAll()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete(new Action() {
                        @Override
                        public void run() throws Exception {
                            mView.renderSampleList(mStorage.getSampleList());
                            mView.hideLoading();
                        }
                    })
                    .subscribe(mStorage.questionListObserver);

        }
    };


}
