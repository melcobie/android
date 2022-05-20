package com.example.test.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.R;
import com.example.test.view.SettingDialog;

public class Setting extends Fragment {

    private ImageView image;

    public Setting() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Setting newInstance() {
        Setting fragment = new Setting();
        return fragment;
    }

    public void init (View v){
        this.image = (ImageView) v.findViewById(R.id.setting_image);
        this.image.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingDialog dialog = new SettingDialog();
                Log.d("parent", getParentFragmentManager().toString());
                dialog.show(getParentFragmentManager(), "test");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        this.init(view);
        // Inflate the layout for this fragment
        return view;
    }
}