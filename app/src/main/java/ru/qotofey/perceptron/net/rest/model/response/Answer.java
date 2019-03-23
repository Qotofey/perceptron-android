package ru.qotofey.perceptron.net.rest.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("vector")
    @Expose
    public List<Long> vector = null;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}
