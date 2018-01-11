package com.example.reueljohn.first;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by reueljohn on 11/01/2018.
 */

public class GetPhotos extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;


    public GetPhotos(ImageView imageView){

        this.imageView = imageView;

    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        String urls = strings[0];
        Bitmap bitMap = null;

        try {
            URL url = new URL(urls);
            InputStream is = url.openConnection().getInputStream();
            bitMap = BitmapFactory.decodeStream(is);
            return bitMap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageView.setImageBitmap(bitmap);

    }
}
