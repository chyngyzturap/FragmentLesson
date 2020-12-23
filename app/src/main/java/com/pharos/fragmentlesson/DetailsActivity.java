package com.pharos.fragmentlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    private String title;
    private String subTitle;
    private int imageResourceId;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent!=null){
            title = intent.getStringExtra(MainActivity.KEY);
            subTitle = intent.getStringExtra(MainActivity.KEY2);
            imageResourceId = intent.getIntExtra(MainActivity.KEY3, 0);
        }
        fragmentManager = getSupportFragmentManager();
        TextFragment fragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragmentText);
transaction = fragmentManager.beginTransaction();
fragment.displayDetails(title, subTitle, imageResourceId);
transaction.commit();
    }
}