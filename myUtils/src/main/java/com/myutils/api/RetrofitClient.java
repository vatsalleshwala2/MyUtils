package com.myutils.api;

import androidx.annotation.NonNull;

import com.myutils.DialogUtils;
import com.myutils.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitClient {
    public static <T> void callApi(Call<T> call, ApiResponse response) {

        if (!NetworkUtil.isNetworkAvailable()) {
            response.networkNotAvailable();
            return;
        }

        DialogUtils.showDialogPleaseWait();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response1) {
                DialogUtils.hideDialog();
                if (response1.isSuccessful()) {
                    response.onSuccess(response1);
                } else {
                    if (response1.errorBody() != null) {
                        response.responseNotSuccess(response1.errorBody());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                response.onFailure(call, t);
                DialogUtils.hideDialog();
            }
        });

    }

    public static <T> void callCancel(Call<T> call) {
        if (call != null) {
            call.cancel();
        }
    }
}
