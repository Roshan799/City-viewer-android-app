package com.example.roshan.cityviewer;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends Fragment {
    EditText e,e2;
    Button b,bk_hotel,bk_bus,bk_train,bk_air,show;


    public PlanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_plan, container, false);
        e=(EditText)view.findViewById(R.id.city);
        e2=(EditText)view.findViewById(R.id.city2);
        b=(Button)view.findViewById(R.id.plan);
        bk_hotel=(Button)view.findViewById(R.id.book_hotel);
        bk_bus=(Button)view.findViewById(R.id.book_bus);
        bk_train=(Button)view.findViewById(R.id.book_train);
        bk_air=(Button)view.findViewById(R.id.book_air);
        show=(Button)view.findViewById(R.id.sh_plan);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),ListActivity.class);
                startActivity(in);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=e.getText().toString();
                String c2=e2.getText().toString();
                if(c.equals("")||c2.equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter city",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent in = new Intent(getActivity(), GmapActivity.class);
                    in.putExtra("cityname",c);
                    in.putExtra("cityname2",c2);
                    in.putExtra("btn","plan");
                    startActivity(in);
                }
            }
        });
        bk_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=e.getText().toString();
                String c2=e2.getText().toString();
                if(c.equals("")||c2.equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter city",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent in = new Intent(getActivity(), GmapActivity.class);
                    in.putExtra("cityname", c);
                    in.putExtra("cityname2", c2);
                    in.putExtra("btn", "hotel");
                    startActivity(in);
                }

            }
        });
        bk_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=e.getText().toString();
                String c2=e2.getText().toString();
                if(c.equals("")||c2.equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter city",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent in = new Intent(getActivity(), GmapActivity.class);
                    in.putExtra("cityname", c);
                    in.putExtra("cityname2", c2);
                    in.putExtra("btn", "bus");
                    startActivity(in);
                }
            }
        });
        bk_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=e.getText().toString();
                String c2=e2.getText().toString();
                if(c.equals("")||c2.equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter city",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent in = new Intent(getActivity(), GmapActivity.class);
                    in.putExtra("cityname", c);
                    in.putExtra("cityname2", c2);
                    in.putExtra("btn", "train");
                    startActivity(in);
                }
            }
        });
        bk_air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=e.getText().toString();
                String c2=e2.getText().toString();
                if(c.equals("")||c2.equals(""))
                {
                    Toast.makeText(getActivity(),"Please Enter city",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent in = new Intent(getActivity(), GmapActivity.class);
                    in.putExtra("cityname", c);
                    in.putExtra("cityname2", c2);
                    in.putExtra("btn", "air");
                    startActivity(in);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
