package com.example.roshan.cityviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class GmapActivity extends AppCompatActivity {
    WebView wb;
    String url,urlhotel,urlbus,urltrain,urlair,t;
    RelativeLayout r;
    Button fin;
    EditText et,tt;
    String placearr;
    DataBaseSql db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmap);
        wb=(WebView)findViewById(R.id.wb_view);
        r=(RelativeLayout)findViewById(R.id.layout_view);
        fin=(Button)findViewById(R.id.finish);
        et=(EditText)findViewById(R.id.editText);
        tt=(EditText)findViewById(R.id.ttl);
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        url="https://www.google.co.in/maps/place/";
        urlhotel="https://www.google.co.in/search?q=book+hotel+in";
        urlbus="https://www.google.co.in/search?q=book+bus+tickets+from";
        urltrain="https://www.google.co.in/search?q=book+train+tickets+from";
        urlair="https://www.google.co.in/search?q=book+air+tickets+from";
        final Intent getvalue=this.getIntent();
        String city=getvalue.getStringExtra("cityname");
        String btn=getvalue.getStringExtra("btn");
        String city2=getvalue.getStringExtra("cityname2");
        db=new DataBaseSql(this);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placearr = et.getText().toString();
                t=tt.getText().toString();
                if(t.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please insert title",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean isInserted = db.insertData(t, placearr);
                    if (isInserted) {
                        Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        if(btn.equals("plan")) {
            wb.loadUrl(url + city);
        }
        if(btn.equals("hotel"))
        {
            wb.loadUrl(urlhotel+" "+city);
        }
        if(btn.equals("bus"))
        {
            wb.loadUrl(urlbus+" "+city2+" to "+city);
        }
        if(btn.equals("train"))
        {
            wb.loadUrl(urltrain+" "+city2+" to "+city);
        }
        if(btn.equals("air"))
        {
            wb.loadUrl(urlair+" "+city2+" to "+city);
        }
    }
}
