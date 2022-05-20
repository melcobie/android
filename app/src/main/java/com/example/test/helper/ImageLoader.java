package com.example.test.helper;

import android.content.Context;
import android.widget.ImageView;

import com.example.test.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void loadImage(ImageView imageView, String url){
        Picasso.get().load(url).placeholder(R.drawable.icone)
        .into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
