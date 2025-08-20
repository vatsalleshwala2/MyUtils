package com.reelmaker.myutils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.myutils.DialogUtils;
import com.myutils.NetworkUtil;
import com.myutils.ToastUtils;
import com.myutils.api.APIClient;
import com.myutils.api.ApiResponse;
import com.myutils.api.RetrofitClient;
import com.myutils.dialog.SpotsDialog;
import com.reelmaker.myutils.model.PostsModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@SuppressLint({"MissingInflatedId", "SetTextI18n"})
public class MainActivity extends AppCompatActivity{
    final String TAG = getClass().getSimpleName();
    private static AlertDialog alertDialog;
    MaterialTextView materialTextView;
    MaterialTextView materialTextView1;
    MaterialTextView materialTextView2;
    MaterialTextView materialTextView3;
    MaterialTextView materialTextView4;
    MaterialTextView materialTextView5;

    LinearLayoutCompat llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button0).setOnClickListener(v -> DialogUtils.showDialogPleaseWait());
        findViewById(R.id.button1).setOnClickListener(v -> {
            alertDialog = new SpotsDialog.Builder()
                    .setContext(this)
                    .setDotsCount(7)
                    .setDotsColor(Color.parseColor("#00ff00"))
                    .setMessageColor(Color.parseColor("#FF0000"))
                    .setMessageTextSize(16)
                    .setBgColor(Color.CYAN)
                    .build();
            alertDialog.show();

        });
        findViewById(R.id.button2).setOnClickListener(v -> ToastUtils.showToastSuccess("Success"));
        findViewById(R.id.button3).setOnClickListener(v -> ToastUtils.showToastError("Error"));
        findViewById(R.id.button4).setOnClickListener(v -> ToastUtils.showToastInfo("Info"));
        findViewById(R.id.button5).setOnClickListener(v -> ToastUtils.showToastWarning("Warning"));

        llMain = findViewById(R.id.llMain);
        materialTextView = findViewById(R.id.materialTextView);
        materialTextView.setText("---> Network Available: " + NetworkUtil.isNetworkAvailable());
        materialTextView1 = findViewById(R.id.materialTextView1);
        materialTextView1.setText("---> Connection Status: " + NetworkUtil.getConnectionStatus());
        materialTextView2 = findViewById(R.id.materialTextView2);
        materialTextView2.setText("---> Connection Status In Character: " + NetworkUtil.getConnectionStatusString());
        materialTextView3 = findViewById(R.id.materialTextView3);
        materialTextView3.setText("---> Wifi Name: " + NetworkUtil.getWifiName());
        materialTextView4 = findViewById(R.id.materialTextView4);
        materialTextView4.setText("---> Mobile Network Name: " + NetworkUtil.getMobileNetworkName());
        materialTextView5 = findViewById(R.id.materialTextView5);
        materialTextView5.setText("---> Gateway: " + NetworkUtil.getGateway());

        /*Log.e(TAG, "get Int Value " + SPUtilsStatic.getInt("int"));
        Log.e(TAG, "get string Value " + SPUtilsStatic.getString("string"));
        Log.e(TAG, "get boolean Value " + SPUtilsStatic.getBoolean("boolean"));
        Log.e(TAG, "get float Value " + SPUtilsStatic.getFloat("float"));
        Log.e(TAG, "get long Value " + SPUtilsStatic.getLong("long"));
        Log.e(TAG, "get double Value " + SPUtilsStatic.getDouble("double"));


        Log.e(TAG, "get Int default Value " + SPUtilsStatic.getInt("int", 2));
        Log.e(TAG, "get string default Value " + SPUtilsStatic.getString("string", "hello"));
        Log.e(TAG, "get boolean default Value " + SPUtilsStatic.getBoolean("boolean", true));
        Log.e(TAG, "get float default Value " + SPUtilsStatic.getFloat("float", 1.5f));
        Log.e(TAG, "get long default Value " + SPUtilsStatic.getLong("long", 1814684684));
        Log.e(TAG, "get double default Value " + SPUtilsStatic.getDouble("double", 531513.18));*/

        /*SPUtilsStatic.setInt("int", 14);
        SPUtilsStatic.setString("string", "xyz");
        SPUtilsStatic.setBoolean("boolean", true);
        SPUtilsStatic.setFloat("float", 48.204f);
        SPUtilsStatic.setLong("long", 98989898);
        SPUtilsStatic.setDouble("double", 5252525.52);


        Log.e(TAG, "get Int Value:###### " + SPUtilsStatic.getInt("int"));
        Log.e(TAG, "get string Value:###### " + SPUtilsStatic.getString("string"));
        Log.e(TAG, "get boolean Value:###### " + SPUtilsStatic.getBoolean("boolean"));
        Log.e(TAG, "get float Value:###### " + SPUtilsStatic.getFloat("float"));
        Log.e(TAG, "get long Value:###### " + SPUtilsStatic.getLong("long"));
        Log.e(TAG, "get double Value:###### " + SPUtilsStatic.getDouble("double"));

        Log.e(TAG, "get Int default Value:###### " + SPUtilsStatic.getInt("int", 2));
        Log.e(TAG, "get string default Value:###### " + SPUtilsStatic.getString("string", "are"));
        Log.e(TAG, "get boolean default Value:###### " + SPUtilsStatic.getBoolean("boolean", true));
        Log.e(TAG, "get float default Value:###### " + SPUtilsStatic.getFloat("float", 1.5f));
        Log.e(TAG, "get long default Value:###### " + SPUtilsStatic.getLong("long", 1814684684));
        Log.e(TAG, "get double default Value:###### " + SPUtilsStatic.getDouble("double", 531513.18));*/


        /*Log.e(TAG, "get arrayList Value " + SPUtilsStatic.getArrayList("array_list"));
        Log.e(TAG, "get object Value " + SPUtilsStatic.getObject("object", Model.class));

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("How");
        arrayList.add("Are");
        arrayList.add("You");
        arrayList.add("?");
        SPUtilsStatic.saveArrayList("array_list", arrayList);

        Model model = new Model();
        model.id = 2;
        model.name = "Hello How Are You?";
        SPUtilsStatic.saveObject("object", model);

        ArrayList<String> arrayList2 = SPUtilsStatic.getArrayList("array_list");
        Model model1 = (Model) SPUtilsStatic.getObject("object", Model.class);
        Log.e(TAG, "get arrayList Value:###### " + new Gson().toJson(arrayList2));
        Log.e(TAG, "get object Value:###### " + new Gson().toJson(model1));

        new Handler().postDelayed(() -> {
            ScreenShotOfView.saveImage(llMain,
                    false,
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(),
                    "ABCD",
                    ScreenShotOfView.ImageType.PNG,
                    new ScreenShotOfView.ImageSaveCallback() {
                        @Override
                        public void FilePath(String path, Uri uri) {

                            Log.e(TAG, "ABCD " + path);
                        }

                        @Override
                        public void Error(IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
            ScreenShotOfView.saveImage(llMain,
                    true,
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(),
                    "ABCDE",
                    ScreenShotOfView.ImageType.PNG,
                    new ScreenShotOfView.ImageSaveCallback() {
                        @Override
                        public void FilePath(String path, Uri uri) {

                            Log.e(TAG, "ABCDE " + path);
                        }

                        @Override
                        public void Error(IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }, 1000);*/

//        Log.e(TAG, "getDeviceType " + DeviceTypeChecker.getDeviceType());


        /*Call<ArrayList<PostsModel>> call = APIClient.getClient("https://jsonplaceholder.typicode.com/").create(APIInterface.class)
                .getPosts();
        RetrofitClient.callApi(call, new ApiResponse<>() {
            @Override
            public void onSuccess(Response<ArrayList<PostsModel>> response) {
                ArrayList<PostsModel> arrayList = response.body();
                Log.e(TAG, "response " + new Gson().toJson(arrayList));
            }

            @Override
            public void responseNotSuccess(ResponseBody body) {
                Log.e(TAG, "responseNotSuccess " + new Gson().toJson(body));
            }

            @Override
            public void onFailure(Call<ArrayList<PostsModel>> call, Throwable t) {
                Log.e(TAG, "onFailure " + t.getLocalizedMessage());
            }

            @Override
            public void networkNotAvailable() {
                Log.e(TAG, "networkNotAvailable " );
            }
        });*/
    }
}