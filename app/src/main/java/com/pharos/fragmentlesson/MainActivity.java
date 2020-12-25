package com.pharos.fragmentlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{
public static final String KEY = "key1";
public static final String KEY2 = "key2";
public  static final String KEY3 = "imgKey";

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private View fragmentView;
    private boolean mViewFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = findViewById(R.id.fragment_second);

        if (fragmentView != null){
            mViewFragment = true;
        }
        if (mViewFragment){
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            //transaction.replace(R.id.fragment_first, new ChangeFragment());
            transaction.commit();
        }
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        //transaction.add(R.id.fragment_first_main, new ChangeFragment());
        transaction.commit();
    }

    public void displayDetails(String title, String subTitle, int imageResourceId){
       View fragmentView = findViewById(R.id.fragment_second);

        if (fragmentView != null) {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_second, TextFragment.newInstance(title, subTitle, imageResourceId));
            transaction.commit();
        }
        else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY, title);
            intent.putExtra(KEY2,subTitle);
            intent.putExtra(KEY3,imageResourceId);
            startActivity(intent);

        }
    }
}