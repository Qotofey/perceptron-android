package ru.qotofey.perceptron.net.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Answer extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}
