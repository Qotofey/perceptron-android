package ru.qotofey.perceptron.net.rest.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.qotofey.perceptron.net.ApiMethods;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public interface QuestionsApi {

    @GET(ApiMethods.QUESTIONS_GET)
    Observable<List<Question>> getAll();


}
