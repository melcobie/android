package com.example.test.view.fragment.lesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.R;
import com.example.test.helper.Redirection;
import com.example.test.view.fragment.HomeFragment;

public class LessonsFragment extends Fragment {

    ImageView back;
    ImageView animals;
    ImageView things;

    public final static String ANIMAL = "ANIMAL";
    public final static String THING = "THING";

    public LessonsFragment() {
        // Required empty public constructor
    }

    public static LessonsFragment newInstance(String param1, String param2) {
        LessonsFragment fragment = new LessonsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void init(View view){
        this.back = (ImageView) view.findViewById(R.id.back_button);
        this.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToPreviousFragment(getParentFragmentManager(), new HomeFragment());
            }
        });

        this.animals = (ImageView)view.findViewById(R.id.animals_menu);
        this.things = (ImageView)view.findViewById(R.id.things_menu);

        this.animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getParentFragmentManager(), ListFragment.newInstance(LessonsFragment.ANIMAL));
            }
        });
        this.things.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getParentFragmentManager(), ListFragment.newInstance(LessonsFragment.THING));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);

        this.init(view);

        return view;
    }
}