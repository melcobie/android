package com.example.test.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.test.R;
import com.example.test.helper.Redirection;
import com.example.test.view.fragment.HomeFragment;
import com.example.test.view.fragment.LessonsFragment;

public class HomepageActivity extends AppCompatActivity {

    ImageView homeButton;
    ImageView learnButton;
    ImageView gameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        this.init();
    }

    public void init(){
        this.homeButton = (ImageView)findViewById(R.id.home_button);
        this.learnButton = (ImageView)findViewById(R.id.learn_button);
        this.gameButton = (ImageView)findViewById(R.id.game_button);

        Fragment homepage = new HomeFragment();
        Fragment lessons = new LessonsFragment();

        FragmentTransaction frgTrans = getSupportFragmentManager().beginTransaction();
        frgTrans.replace(R.id.content, homepage);
        frgTrans.commit();

        this.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getSupportFragmentManager(), homepage);
            }
        });

        this.learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redirection.goToFragment(getSupportFragmentManager(), lessons);
            }
        });
    }
}