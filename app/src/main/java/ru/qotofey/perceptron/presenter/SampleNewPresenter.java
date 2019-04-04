package ru.qotofey.perceptron.presenter;

import android.app.Activity;
import android.content.Context;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.api.QuestionsApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.view.SampleNewView;

public class SampleNewPresenter extends BasePresenter {

    private SampleNewView mView;

    @Inject
    SampleStorage mStorage;
    @Inject
    AnswersApi mAnswersApi;
    @Inject
    QuestionsApi mQuestionsApi;

    public SampleNewPresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleNewView view) {
        mView = view;
    }

    public void init() {
        mView.hideLoading();
    }

    public void saveDataToNet(final String answerText, final String questionText) {
        JsonObject answerBody = new JsonObject();
        answerBody.addProperty("text", answerText);
        mAnswersApi.post(answerBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterNext(new Consumer<Answer>() {
                    @Override
                    public void accept(Answer answer) throws Exception {
                        JsonObject questionBody = new JsonObject();
                        questionBody.addProperty("text", questionText);
                        questionBody.addProperty("answer_id", answer.id);
                        mQuestionsApi.post(questionBody)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doFinally(new Action() {
                                    @Override
                                    public void run() throws Exception {
                                        mView.hideLoading();
                                        mView.enableButtons();
                                        ((Activity) mView).finish();
                                    }
                                })
                                .subscribe(mStorage.questionObserver);
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showLoading();
                        mView.disableButtons();
                    }
                })
                .subscribe(mStorage.answerObserver);
    }

}
