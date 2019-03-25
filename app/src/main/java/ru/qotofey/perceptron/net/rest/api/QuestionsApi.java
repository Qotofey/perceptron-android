package ru.qotofey.perceptron.net.rest.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public interface QuestionsApi {

    @GET("questions/")
    Call<List<Question>> get();

}
