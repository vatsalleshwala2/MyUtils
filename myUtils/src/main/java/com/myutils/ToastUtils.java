package com.myutils;

import static com.myutils.ActivityAndContextSet.context;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

@SuppressLint({"InflateParams", "StaticFieldLeak"})
public class ToastUtils {

    private static ToastUtils toastUtils;
    LayoutInflater inflater;

    public static ToastUtils getInstance() {
        if (toastUtils == null) {
            toastUtils = new ToastUtils();
        }
        return toastUtils;
    }

    public synchronized void initialize() {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setToastSuccess();
        setErrorToast();
        setToastInfo();
        setToastWarning();
    }

    private static Toast toastSuccess, toastError, toastInfo, toastWarning;
    private static MaterialTextView lblToastSuccess, lblToastError, lblToastInfo, lblWarning;

    private void setToastSuccess() {
        View view = inflater.inflate(R.layout.toast_layout_success, null);
        lblToastSuccess = view.findViewById(R.id.lblToast);
        lblToastSuccess.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toastSuccess = new Toast(context.getApplicationContext());
        toastSuccess.setDuration(Toast.LENGTH_SHORT);
        toastSuccess.setView(view);
    }
    public static void showToastSuccess(String msg) {
        try {
            lblToastSuccess.setText(msg);
            toastSuccess.show();
        } catch (Exception ignored) {

        }
    }

    private void setErrorToast() {
        View view = inflater.inflate(R.layout.toast_layout_error, null);
        lblToastError = view.findViewById(R.id.lblToast);
        lblToastError.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toastError = new Toast(context);
        toastError.setDuration(Toast.LENGTH_LONG);
        toastError.setView(view);
    }
    public static void showToastError(String msg) {
        try {
            lblToastError.setText(msg);
            toastError.show();
        } catch (Exception ignored) {

        }
    }

    private void setToastInfo() {
        View view = inflater.inflate(R.layout.toast_layout_info, null);
        lblToastInfo = view.findViewById(R.id.lblToast);
        lblToastInfo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toastInfo = new Toast(context.getApplicationContext());
        toastInfo.setDuration(Toast.LENGTH_SHORT);
        toastInfo.setView(view);
    }
    public static void showToastInfo(String msg) {
        try {
            lblToastInfo.setText(msg);
            toastInfo.show();
        } catch (Exception ignored) {

        }
    }

    private void setToastWarning() {
        View view = inflater.inflate(R.layout.toast_layout_warning, null);
        lblWarning = view.findViewById(R.id.lblToast);
        lblWarning.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toastWarning = new Toast(context.getApplicationContext());
        toastWarning.setDuration(Toast.LENGTH_SHORT);
        toastWarning.setView(view);
    }
    public static void showToastWarning(String msg) {
        try {
            lblWarning.setText(msg);
            toastWarning.show();
        } catch (Exception ignored) {

        }
    }

}
