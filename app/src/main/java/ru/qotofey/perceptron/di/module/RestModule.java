package ru.qotofey.perceptron.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.qotofey.perceptron.net.rest.api.AnswersApi;
import ru.qotofey.perceptron.net.rest.api.QuestionsApi;
import ru.qotofey.perceptron.net.RestClient;

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule() {
        if (mRestClient == null) {
            mRestClient = new RestClient();
        }
    }

    @Provides
    @Singleton
    RestClient provideRestClient() {
        return mRestClient;
    }

    @Provides
    @Singleton
    AnswersApi provideAnswersApi() {
        return mRestClient.createService(AnswersApi.class);
    }

    @Provides
    @Singleton
    QuestionsApi provideQuestionsApi() {
        return mRestClient.createService(QuestionsApi.class);
    }

}
