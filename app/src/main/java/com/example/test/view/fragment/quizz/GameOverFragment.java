package com.example.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.view.fragment.quizz.StartQuizzFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameOverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameOverFragment extends Fragment {

    private int score;

    public GameOverFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GameOverFragment newInstance(int score) {
        GameOverFragment fragment = new GameOverFragment();
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
        View v = inflater.inflate(R.layout.fragment_game_over, container, false);

        this.init(v);

        return v;
    }

    public void init(View v){
        TextView score = (TextView)v.findViewById(R.id.score_final);
        score.setText(""+this.score);

        Button restart = (Button)v.findViewById(R.id.restart_quizz);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.quizz_content, StartQuizzFragment.newInstance())
                        .commit();
            }
        });
    }
}