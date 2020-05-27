package com.example.roshan.cityviewer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    TextView abt;
    Button ab;


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_setting, container, false);
        ab=(Button) view.findViewById(R.id.about);
        abt=(TextView)view.findViewById(R.id.abt);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abt.setText("Description about the app");
            }
        });
        return view;
    }

}
