package ru.qotofey.perceptron.net.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("answer_id")
    @Expose
    public Long answerId;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}