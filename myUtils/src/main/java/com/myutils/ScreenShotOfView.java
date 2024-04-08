package com.myutils;

import static com.myutils.ActivityAndContextSet.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenShotOfView {

    public interface ImageSaveCallback {
        void FilePath(String path, Uri uri);

        void Error(IOException e);
    }

    public enum ImageType {
        JPG,
        PNG,
    }

    public static void saveImage(View view, boolean highResolution, String folderPath, String fileName, ImageType imageType, ImageSaveCallback imageSaveCallback) {
        Bitmap bitmap = loadBitmapFromView(view, highResolution);
        File file = new File(folderPath);
        if (!file.exists()) file.mkdirs();

        File myfile;
        if (imageType.name().equals(ImageType.JPG.name())) {
            myfile = new File(file, fileName + ".jpg");
        } else {
            myfile = new File(file, fileName + ".png");
        }


        if (myfile.exists()) {
            myfile.delete();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            if (imageType.name().equals(ImageType.JPG.name())) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            }

            fileOutputStream.flush();
            fileOutputStream.close();
            MediaScannerConnection.scanFile(activity, new String[]{myfile.getPath()}, null, imageSaveCallback::FilePath);

        } catch (IOException e) {
            imageSaveCallback.Error(e);
        }
    }

    private static Bitmap loadBitmapFromView(View v, boolean highResolution) {
        Canvas bitmapCanvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(highResolution ? v.getWidth() * 2 : v.getWidth(), highResolution ? v.getHeight() * 2 : v.getHeight(), Bitmap.Config.ARGB_8888);

        float scale = highResolution ? 2f : 1f;
        bitmapCanvas.setBitmap(bitmap);
        bitmapCanvas.scale(scale, scale);
        v.draw(bitmapCanvas);

        return bitmap;
    }

}
