package ru.qotofey.perceptron.net.rest.api;


import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.qotofey.perceptron.net.ApiMethods;
import ru.qotofey.perceptron.net.rest.model.response.Answer;

public interface AnswersApi {

    @GET(ApiMethods.ANSWERS_GET)
    Observable<List<Answer>> getAll();

    @GET(ApiMethods.ANSWER_GET)
    Observer<Answer> get(@Path("id") int id);

}
