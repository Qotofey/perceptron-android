package ru.qotofey.perceptron.net.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerceptronError {

    @SerializedName("result_error")
    @Expose
    public Double resultError;

}