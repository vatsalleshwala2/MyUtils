package com.reelmaker.myutils.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseModel {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("data")
    @Expose
    public List<Datum> data;
    @SerializedName("support")
    @Expose
    public Support support;

    public static class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("avatar")
        @Expose
        public String avatar;

    }

    public static class Support {

        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("text")
        @Expose
        public String text;

    }
}
