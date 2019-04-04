package ru.qotofey.perceptron.net.rest.api;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import ru.qotofey.perceptron.net.ApiMethods;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public interface QuestionsApi {

    @GET(ApiMethods.QUESTIONS)
    Observable<List<Question>> getAll();

    @GET(ApiMethods.QUESTION)
    Observable<Question> get(@Path("id") Long id);

    @POST(ApiMethods.QUESTIONS)
    Observable<Question> post(@Body JsonObject body);

    @PUT(ApiMethods.QUESTION)
    Observable<Question> put(
            @Path("id") int id,
            @QueryMap Map<String, String> map
    );

    @DELETE(ApiMethods.QUESTION)
    Observable<Question> delete(@Path("id") Long id);
}
