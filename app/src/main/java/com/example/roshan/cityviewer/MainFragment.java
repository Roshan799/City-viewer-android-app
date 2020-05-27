package com.example.roshan.cityviewer;



import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    ImageView ht,trans,hs,pl;




    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        ht=(ImageView)view.findViewById(R.id.hotelview);
        trans=(ImageView)view.findViewById(R.id.busview);
        hs=(ImageView)view.findViewById(R.id.houseview);
        pl=(ImageView)view.findViewById(R.id.placeview);



        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),MapsActivity.class);
                in.putExtra("Key","hotel");
                startActivity(in);
            }
        });
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),MapsActivity.class);
                in.putExtra("Key","public transport");
                startActivity(in);
            }
        });
        hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),MapsActivity.class);
                in.putExtra("Key","guest house");
                startActivity(in);
            }
        });
        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),MapsActivity.class);
                in.putExtra("Key","tourist places");
                startActivity(in);
            }
        });
        return (view);
    }


}
