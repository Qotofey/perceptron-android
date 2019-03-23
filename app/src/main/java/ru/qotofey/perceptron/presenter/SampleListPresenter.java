package ru.qotofey.perceptron.presenter;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.view.SampleListView;

public class SampleListPresenter extends BasePresenter {

    private SampleListView mView;
//    private Observable<List<Sample>> mModel;

    public SampleListPresenter() {

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
//        mModel
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(mView);
    }




}
