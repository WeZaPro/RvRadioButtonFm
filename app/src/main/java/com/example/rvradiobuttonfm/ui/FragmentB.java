package com.example.rvradiobuttonfm.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rvradiobuttonfm.R;
import com.example.rvradiobuttonfm.model.MyModel;

public class FragmentB extends Fragment {

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        TextView textView1 = v.findViewById(R.id.textViewFmB1);
        TextView textView2 = v.findViewById(R.id.textViewFmB2);

        if (getArguments() != null) {
            MyModel myModel = new MyModel();
            myModel = getArguments().getParcelable("key");

            textView1.setText("country : " + myModel.getCountry());
            textView2.setText("rates : " + myModel.getRates());

            Log.d("check", "country : " + myModel.getCountry());
            Log.d("check", "rates : " + myModel.getRates());

        }
        return v;
    }

}