package com.example.aku_pintar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rvList;

    private tesdb db;
    private tesAdapter adapter;
    private List<tesmodel> univer = new ArrayList<>();
    TextView greetText;
    ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        db = new tesdb(getContext());

        rvList = rootView.findViewById(R.id.rv_univ);

        adapter = new tesAdapter(getContext());
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);



     return rootView;


    }


    @Override
    public void onResume() {
        super.onResume();
        getUnivtast();
    }

    private void getUnivtast() {
        univer = db.getUniv();
        adapter.setUniver(univer);
    }


}