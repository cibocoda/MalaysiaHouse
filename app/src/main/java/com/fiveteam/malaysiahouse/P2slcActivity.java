package com.fiveteam.malaysiahouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class P2slcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2slc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvslc = (TextView) findViewById(R.id.TV_p2slc_title);
        TextView tvslcin = (TextView) findViewById(R.id.TV_p2slc_inside);
        Bundle bundle = getIntent().getExtras();
        tvslc.setText(bundle.getString("title"));
        String temp = bundle.getString("title")+"項目";
        tvslcin.setText(temp);
    }

}
