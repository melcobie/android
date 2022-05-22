package com.example.test.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.Utils.RetrofitClient;
import com.example.test.controller.ListController;
import com.example.test.helper.Redirection;
import com.example.test.model.Categorie;
import com.example.test.model.Item;
import com.example.test.services.LeconsServices;
import com.example.test.view.adapter.ItemListAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    ListController listController;
    ListView listView;
    String type;

    public ListFragment() {
        // Required empty public constructor
    }


    public static ListFragment newInstance(String type) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void init(View view){
        this.listView = (ListView) view.findViewById(R.id.list);
        ArrayList<Item> item = this.listController.getItems(this.type);

        ItemListAdapter itemListAdapter = new ItemListAdapter(view.getContext(), item);

        listView.setAdapter(itemListAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DetailsFragment detailsFragment = DetailsFragment.newInstance(item.get(i));
                Redirection.goToFragment(getParentFragmentManager(), detailsFragment);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        this.listController = ListController.getInstance(getContext());
        this.init(view);

        return view;
    }
}