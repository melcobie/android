package com.example.test.view.fragment.quizz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link McqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class McqFragment extends Fragment {

    private int score;

    public McqFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static McqFragment newInstance(int score) {
        McqFragment fragment = new McqFragment();
        Bundle args = new Bundle();
        args.putInt("score", score);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.score = getArguments().getInt("score");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mcq, container, false);

        this.init(view);

        return view;
    }

    public void init(View v){
        TextView score = (TextView) v.findViewById(R.id.score);
        score.setText(""+this.score);
    }
}