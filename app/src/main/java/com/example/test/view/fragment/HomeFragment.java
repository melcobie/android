package com.example.test.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.test.R;
import com.example.test.helper.Redirection;
import com.example.test.view.fragment.lesson.LessonsFragment;
import com.example.test.view.fragment.quizz.QuizzFragment;

public class HomeFragment extends Fragment {

    private ImageView learnButton;
    private ImageView quizzButton;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void init(View view){
        this.learnButton = (ImageView)view.findViewById(R.id.lesson_image);
        this.quizzButton = (ImageView)view.findViewById(R.id.quizz_image);
        
        Fragment lessons = new LessonsFragment();
        Fragment quizz = new QuizzFragment();

        this.learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getParentFragmentManager(), lessons);
            }
        });

        this.quizzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getParentFragmentManager(), quizz);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.init(view);
        return view;
    }
}