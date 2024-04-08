package com.reelmaker.myutils;

import com.reelmaker.myutils.model.APIResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("users?")
    Call<APIResponseModel> doGetUserList(
            @Query("page") String page
    );

}
