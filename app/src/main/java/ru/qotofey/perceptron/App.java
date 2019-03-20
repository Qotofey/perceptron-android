package ru.qotofey.perceptron;

import android.app.Application;

import ru.qotofey.perceptron.di.component.AppComponent;
import ru.qotofey.perceptron.di.component.DaggerAppComponent;
import ru.qotofey.perceptron.di.module.AppModule;
import ru.qotofey.perceptron.di.module.RestModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        sAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .restModule(new RestModule())
                .build();
    }
}
