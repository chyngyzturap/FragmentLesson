package com.pharos.fragmentlesson;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private static final String KEY_S = "keyString";
    private static final String KEY_S1 = "keyString1";
    private static final String KEY_S2 = "keyInt";

    private TextView textView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    public static final String KEY = "edKey";



    private String mParam1;
    private String mParam2;
    private int mParam3;

    private EditText editText;
    private Button btnSend;

    private int savedID;

    private Button btnSkip;
    private Button btnNext;
    private ViewPager pager;

    private ImageView imageId;

    public TextFragment() {
    }


    public static TextFragment newInstance(String param1, String param2, int param3) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text, container, false);
        btnNext = view.findViewById(R.id.btnNext);
        btnSkip = view.findViewById(R.id.btnSkip);
        btnSend = view.findViewById(R.id.btnSend);
editText = view.findViewById(R.id.editText);
        pager = getActivity().findViewById(R.id.viewPager);
        imageId = view.findViewById(R.id.imageViewRecycler);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity activity = (DetailsActivity) getActivity();
                activity.showMain();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragment changeFragment = new ChangeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("text", editText.getText().toString());
                changeFragment.setArguments(bundle);

                
            }
        });
        return view;
    }
}