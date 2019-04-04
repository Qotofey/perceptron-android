package ru.qotofey.perceptron.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.view.SampleView;

public class SamplePresenter extends BasePresenter {

    private SampleView mView;
    private Sample mSample;
    @Inject SampleStorage mStorage;
    @Inject AnswersApi mAnswersApi;
    @Inject Context mContext;

    public SamplePresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleView view) {
        mView = view;
    }

    public void setModel(UUID sampleId) {
        Log.i(TAG, "Размерность списка выборки: " + mStorage.getSampleList().size());
        mSample = mStorage.getSample(sampleId);
    }

    public void init() {
        mView.showLoading();
        mView.renderSample(mSample);
        mView.hideLoading();
    }

    public void deleteSample() {
        mAnswersApi.delete(mSample.getAnswer().id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Answer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(Answer answer) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.hideLoading();
                        Log.e(TAG, "Сбой!");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "Окончено!");
                        mView.hideLoading();
                    }
                });
    }

}
