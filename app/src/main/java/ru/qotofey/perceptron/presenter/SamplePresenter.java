package ru.qotofey.perceptron.presenter;

import java.util.UUID;

import javax.inject.Inject;

import ru.qotofey.perceptron.App;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.model.SampleStorage;
import ru.qotofey.perceptron.view.SampleView;

public class SamplePresenter extends BasePresenter {

    private SampleView mView;
    private Sample mSample;
    @Inject SampleStorage mStorage;

    public SamplePresenter() {
        App.getComponent().inject(this);
    }

    public void setView(SampleView view) {
        mView = view;
    }

    public void setModel(UUID sampleId) {
        mSample = mStorage.getSample(sampleId);
    }

    public void init() {
        mView.showLoading();
        mView.renderSample(mSample);
        mView.hideLoading();
    }

}
