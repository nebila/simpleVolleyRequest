package com.nebila.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nebila.simplevolleyrequest.SimpleVolleyRequest;


public class MainActivity extends AppCompatActivity {

    TextView rep;
    Button rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rep=findViewById(R.id.tv_rep);
        rec=findViewById(R.id.btn_rec);

        final SimpleVolleyRequest svr = new SimpleVolleyRequest();

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reponse=svr.stringRequest(getBaseContext(), "GET", "http://app.diginfactory.com:9191/", null);

                if(svr.error != null){

                    rep.setText(svr.error);
                    Log.w("erreur", svr.error);
                }else {

                    rep.setText(svr.sResponse);
                    //Log.w("reponse", svr.sResponse);
                }
            }
        });


    }
}
