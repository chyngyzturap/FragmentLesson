package com.pharos.fragmentlesson;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Destination> list;

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setUpRecyclerView();

        return view;
    }

    private void setUpRecyclerView() {
        list = new ArrayList<>();
    list.add(new Destination("Life Is Strange","Life is Strange is an award-winning and critically acclaimed episodic adventure game that allows the player to rewind time and affect the past, present and future.",R.drawable.lifeisstrange));
   list.add(new Destination("Metro 2033", "Metro 2033 is a first-person shooter survival horror video game developed by 4A Games and published by THQ.", R.drawable.metro2033));
    list.add(new Destination("Assassin's Creed", "Assassin's Creed is an open-world action-adventure stealth video game franchise published by Ubisoft and developed mainly by its studio Ubisoft Montreal using the game engine Anvil and its more advanced derivatives.", R.drawable.assassin));

       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list,getContext());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String subtitle, int imageResourceId) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title, subtitle, imageResourceId);

    }
}
