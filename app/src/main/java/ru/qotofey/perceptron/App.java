package ru.qotofey.perceptron;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ru.qotofey.perceptron.di.component.AppComponent;
import ru.qotofey.perceptron.di.component.DaggerAppComponent;
import ru.qotofey.perceptron.di.module.AppModule;
import ru.qotofey.perceptron.di.module.RestModule;
import ru.qotofey.perceptron.di.module.SampleStorageModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initRealm();
    }

    private void initDagger() {
        sAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .restModule(new RestModule())
                .sampleStorageModule(new SampleStorageModule())
                .build();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
