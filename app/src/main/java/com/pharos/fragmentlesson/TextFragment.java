package com.pharos.fragmentlesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



    private String mParam1;
    private String mParam2;
    private int mParam3;

    private int savedID;

    private TextView txtTitle;
    private TextView txtSubTitle;
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
        txtTitle = view.findViewById(R.id.txtTitle);
        txtSubTitle = view.findViewById(R.id.txtSubTitle);
        imageId = view.findViewById(R.id.imageViewRecycler);
        txtTitle.setText(mParam1);
        txtSubTitle.setText(mParam2);
        imageId.setImageResource(mParam3);
        savedID = mParam3;
        return view;
    }

    void displayDetails(String title, String subTitle, int imageResourceId){
        txtTitle.setText(title);
        txtSubTitle.setText(subTitle);
        imageId.setImageResource(imageResourceId);
    }
}