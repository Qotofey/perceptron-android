package ru.qotofey.perceptron.net.rest.api;

import org.json.JSONArray;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import ru.qotofey.perceptron.net.rest.model.response.Answer;

public interface AnswersApi {

    @GET("answers/")
    Call<List<Answer>> get();

}
