package com.fiveteam.malaysiahouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class IntroActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 3000; //頁面停留時間三秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(IntroActivity.this,
                        MainActivity.class);
                IntroActivity.this.startActivity(mainIntent);
                IntroActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }

    public void enterm(View view){
        Intent mainIntent = new Intent(IntroActivity.this,
                MainActivity.class);
        IntroActivity.this.startActivity(mainIntent);
        IntroActivity.this.finish();
    }
}
