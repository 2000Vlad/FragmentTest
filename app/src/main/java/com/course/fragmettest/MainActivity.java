package com.course.fragmettest;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import static com.course.fragmettest.GenderFragment.FEMALE;
import static com.course.fragmettest.GenderFragment.GENDER_KEY;
import static com.course.fragmettest.GenderFragment.MALE;
import static com.course.fragmettest.TextFragment.NAME_KEY;
import static com.course.fragmettest.TextFragment.SURNAME_KEY;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    TextView mNameTextView;
    TextView mGenderTextView;
    TextView mStudiesTextView;
    FrameLayout mFragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        Log.d(getClass().getName(),"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    private void initUi() {
        mNameTextView = findViewById(R.id.name_textview);
        mGenderTextView = findViewById(R.id.gender_textview);
        mStudiesTextView = findViewById(R.id.studies_textview);
        mFragmentContainer = findViewById(R.id.fragment_container);
        mTextFragment = new TextFragment();
    }
    TextFragment mTextFragment;
    GenderFragment mGenderFragment;
    public void setTextFragment(View v){
        Bundle args = new Bundle();
        args.putString(NAME_KEY,"Iancu");
        args.putString(SURNAME_KEY,"Vlad");
        mTextFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,mTextFragment,TextFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();



    }
    public void setGenderFragment(View v){
       Bundle args = new Bundle();
       GenderFragment fragment = new GenderFragment();
       args.putString(GENDER_KEY,MALE);
       fragment.setArguments(args);
       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.fragment_container,fragment,GenderFragment.TAG);
       transaction.commit();
    }

    public void navigate(View view) {
        Intent nav = new Intent(this, StudentsActivity.class);
        startActivity(nav);
    }
}
