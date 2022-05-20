package com.example.test.view.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.test.R;
import com.example.test.helper.ImageLoader;
import com.example.test.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ItemListAdapter extends ArrayAdapter<Item> {
    public ItemListAdapter(Context context, ArrayList<Item> list){
        super(context, R.layout.category_item, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Item item = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.image_liste);
        TextView name = convertView.findViewById(R.id.nom_category);


        name.setText(item.getName());
        try{
            ImageLoader.loadImage(image, item.getUrl());
        }catch (Exception e){
            image.setImageResource(R.drawable.icone);
        }

        return convertView;
    }
}
