package ru.qotofey.perceptron.net.rest.api;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import ru.qotofey.perceptron.net.ApiMethods;
import ru.qotofey.perceptron.net.rest.model.response.Answer;

public interface AnswersApi {

    @GET(ApiMethods.ANSWERS)
    Observable<List<Answer>> getAll();

    @GET(ApiMethods.ANSWER)
    Observable<Answer> get(@Path("id") Long id);

    @POST(ApiMethods.ANSWERS)
    Observable<Answer> post(@Body JsonObject body);

    @PUT(ApiMethods.ANSWER)
    Observable<Answer> put(
            @Path("id") int id,
            @Body JsonObject body
    );

    @DELETE(ApiMethods.ANSWER)
    Observable<Answer> delete(@Path("id") Long id);

}
