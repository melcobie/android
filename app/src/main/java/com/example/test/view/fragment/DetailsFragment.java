package com.example.test.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.helper.ImageLoader;
import com.example.test.model.Item;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ITEM = "item";

    // TODO: Rename and change types of parameters
    private Item item;

    private TextView nom;
    private TextView genre;
    private TextView description;
    private ImageView image;

    public DetailsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(Item item) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(DetailsFragment.ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.item = (Item)getArguments().getSerializable(DetailsFragment.ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        this.bind(view);
        this.initValue(view);

        return view;
    }

    private void bind(View v){
        this.nom = (TextView)v.findViewById(R.id.nom_detail);
        this.genre = (TextView)v.findViewById(R.id.genre_detail);
        this.description = (TextView)v.findViewById(R.id.description_detail);
        this.image = (ImageView)v.findViewById(R.id.image_detail);
    }

    private void initValue(View v){
        this.nom.setText(this.item.getName());
        this.genre.setText(this.item.getGenre());
        this.description.setText(this.item.getDescription());
        try{
            ImageLoader.loadImage(this.image, item.getUrl());
        }catch (Exception e){
            this.image.setImageResource(R.drawable.icone);
        }
    }
}