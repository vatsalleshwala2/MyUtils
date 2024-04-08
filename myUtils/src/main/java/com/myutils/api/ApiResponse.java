package com.myutils.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public interface ApiResponse {
    <T> void onSuccess(Response<T> response);
    void responseNotSuccess(ResponseBody body);
    <T> void onFailure(Call<T> call, Throwable t);
    void networkNotAvailable();
}
