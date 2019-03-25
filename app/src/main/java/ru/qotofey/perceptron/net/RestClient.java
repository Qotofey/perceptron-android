package ru.qotofey.perceptron.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static final String PERCEPTRON_BASE_URL = "http://api-perceptron.qotofey.ru/";

    private Retrofit mRetrofit;

    public RestClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(PERCEPTRON_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
