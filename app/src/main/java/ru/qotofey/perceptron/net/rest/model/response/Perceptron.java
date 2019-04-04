package ru.qotofey.perceptron.net.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perceptron {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("coefficient")
    @Expose
    public Double coefficient;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}
