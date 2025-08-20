package com.reelmaker.myutils;

import com.reelmaker.myutils.model.PostsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("posts")
    Call<ArrayList<PostsModel>> getPosts(
    );

}
