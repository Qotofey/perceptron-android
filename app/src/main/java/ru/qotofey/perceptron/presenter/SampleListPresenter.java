package ru.qotofey.perceptron.presenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.api.QuestionsApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.view.SampleListView;

public class SampleListPresenter extends BasePresenter {


    private SampleListView mView;
//    private Observable<List<Sample>> mModel;

//    @Inject AnswersApi mAnswersApi;
//    @Inject QuestionsApi mQuestionsApi;
//
//    @Inject SampleStorage mStorage;

    public SampleListPresenter() {
//        App.getComponent().inject(this);
    }

    public void setView(SampleListView view) {
        mView = view;
    }

    public void init() {
        mView.showLoading();
        loadDataFromDB();
        loadDataFromNet();
        mView.hideLoading();
    }

    private void loadDataFromDB() {
//        mModel
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(mView);
    }

    private void loadDataFromNet() {

//        mAnswersApi.get()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnTerminate(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        mView.showLoading();
//                    }
//                })
////                .subscribe(mStorage.answerListObserver);
//                .subscribe(new Observer<List<Answer>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Answer> answers) {
//                        mView.renderAnswerList(answers);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


//        mQuestionsApi.get()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnComplete(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        mView.renderSampleList(mStorage.getSampleList());
//                        mView.hideLoading();
//                    }
//                })
//                .subscribe(mStorage.questionListObserver);

//        mStorage.insertAnswerList()
//        mModel
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(mView);
    }


}
