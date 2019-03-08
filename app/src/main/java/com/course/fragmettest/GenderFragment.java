package com.course.fragmettest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenderFragment extends Fragment {
    public static final String TAG = "genderFragment";
    public static final String GENDER_KEY = "gender";
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    RadioButton mMaleButton;
    RadioButton mFemaleButton;

    public GenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender,container,false);
        initView(view);
        return view;
    }
    public void initView(View v){
        mMaleButton = v.findViewById(R.id.male_button);
        mFemaleButton = v.findViewById(R.id.female_button);
        Bundle args = getArguments();
        String gender = args.getString(GENDER_KEY);
        if(gender == MALE) mMaleButton.setChecked(true);
        if(gender == FEMALE) mFemaleButton.setChecked(true);




    }

}
