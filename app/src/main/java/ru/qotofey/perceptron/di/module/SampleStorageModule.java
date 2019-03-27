package ru.qotofey.perceptron.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.qotofey.perceptron.model.SampleStorage;

@Module
public class SampleStorageModule {

    private SampleStorage mSampleStorage;

    public SampleStorageModule() {
        mSampleStorage = new SampleStorage();
    }

    @Singleton
    @Provides
    SampleStorage provideSampleStorage() {
        return mSampleStorage;
    }


}
