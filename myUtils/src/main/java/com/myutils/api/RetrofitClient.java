package com.myutils.api;

import androidx.annotation.NonNull;

import com.myutils.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitClient {

    public static <T> void callApi(Call<T> call, ApiResponse<T> apiResponse) {

        if (!NetworkUtil.isNetworkAvailable()) {
            apiResponse.networkNotAvailable();
            return;
        }

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.isSuccessful()) {
                    apiResponse.onSuccess(call, response);
                } else {
                    if (response.errorBody() != null) {
                        apiResponse.responseNotSuccess(call, response);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                apiResponse.onFailure(call, t);
            }
        });
    }

    public static <T> void callCancel(Call<T> call) {
        if (call != null) {
            call.cancel();
        }
    }
}
