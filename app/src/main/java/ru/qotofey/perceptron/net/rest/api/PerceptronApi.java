package ru.qotofey.perceptron.net.rest.api;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.qotofey.perceptron.net.ApiMethods;
import ru.qotofey.perceptron.net.rest.model.response.ConstAnswer;
import ru.qotofey.perceptron.net.rest.model.response.Perceptron;
import ru.qotofey.perceptron.net.rest.model.response.PerceptronError;

public interface PerceptronApi {

    @POST(ApiMethods.PERCEPTRONS)
    Observable<Perceptron> create(@Body JsonObject body);

    @POST(ApiMethods.PERCEPTRONS_LEARN)
    Observable<PerceptronError> learn(@Body JsonObject body);

    @POST(ApiMethods.PERCEPTRONS_ASK)
    Observable<ConstAnswer> ask(@Body JsonObject body);

}
