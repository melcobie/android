package com.example.test.view.fragment.quizz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.controller.quizz.StartQuizzController;
import com.example.test.helper.Redirection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartQuizzFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartQuizzFragment extends Fragment {
    private StartQuizzController controller;

    public StartQuizzFragment() {
        // Required empty public constructor
    }

    public static StartQuizzFragment newInstance() {
        StartQuizzFragment fragment = new StartQuizzFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.controller = StartQuizzController.getInstance();
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_quizz, container, false);

        this.init(view);

        return view;
    }

    public void init(View v){
        Button start = (Button)v.findViewById(R.id.start_quizz);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(R.id.quizz_content, getParentFragmentManager(), McqFragment.newInstance(0));
            }
        });

        TextView bestScore = (TextView)v.findViewById(R.id.best_score);
        bestScore.setText(""+this.controller.getBestScore());
    }
}