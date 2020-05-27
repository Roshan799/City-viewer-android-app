package com.example.roshan.cityviewer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    DataBaseSql db;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        db=new DataBaseSql(this);
        Cursor res=db.getTitles();
        ArrayList<String> arrayList=new ArrayList<String>();
        if(res.getCount()==0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();
        }
        else
        {
            int i=0;

            while (res.moveToNext())
            {
                arrayList.add(i,res.getString(0));
                i++;
            }
        }
        adapter = new ArrayAdapter<String>(this,
                R.layout.titles, arrayList);

        ListView listView = (ListView) findViewById(R.id.title_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String s=adapter.getItem(position).toString();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                Intent in=new Intent(getApplicationContext(),ShowActivity.class);
                in.putExtra("title",s);
                startActivity(in);
            }
        });
    }
}
