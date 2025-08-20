package com.reelmaker.myutils.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsModel {

    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("body")
    @Expose
    public String body;
}
