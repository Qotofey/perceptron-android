package ru.qotofey.perceptron.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.qotofey.perceptron.di.module.AppModule;
import ru.qotofey.perceptron.di.module.RestModule;
import ru.qotofey.perceptron.di.module.SampleStorageModule;

import ru.qotofey.perceptron.presenter.BasePresenter;
import ru.qotofey.perceptron.presenter.SampleListPresenter;
import ru.qotofey.perceptron.presenter.SampleNewPresenter;
import ru.qotofey.perceptron.presenter.SamplePresenter;

import ru.qotofey.perceptron.view.activity.SampleActivity;
import ru.qotofey.perceptron.view.activity.SampleListActivity;
import ru.qotofey.perceptron.view.activity.SampleNewActivity;
import ru.qotofey.perceptron.view.activity.SingleFragmentActivity;

import ru.qotofey.perceptron.view.fragment.BaseFragment;
import ru.qotofey.perceptron.view.fragment.SampleFragment;
import ru.qotofey.perceptron.view.fragment.SampleListFragment;
import ru.qotofey.perceptron.view.fragment.SampleNewFragment;

@Singleton
@Component(modules = {
        AppModule.class,
        RestModule.class,
        SampleStorageModule.class
})
public interface AppComponent {

    //activities
    void inject(SingleFragmentActivity activity); //abstract
    void inject(SampleActivity activity);
    void inject(SampleListActivity activity);
    void inject(SampleNewActivity activity);

    //fragments
    void inject(BaseFragment fragment); //abstract
    void inject(SampleFragment fragment);
    void inject(SampleListFragment fragment);
    void inject(SampleNewFragment fragment);

    //presenters
    void inject(BasePresenter presenter);
    void inject(SamplePresenter presenter);
    void inject(SampleListPresenter presenter);
    void inject(SampleNewPresenter presenter);


}
