package com.example.monil.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class activity_stopwatch extends AppCompatActivity {

    private  int seconds = 0;
    private  boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState!=null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runtime();
    }

    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }
    public void start(View view)
    {
        running = true;

    }
    public void stop(View view)
    {
        running = false;
    }
    public void reset(View view)
    {
        running = false;
        seconds = 0;
    }

    public void runtime()
    {
        final TextView time = (TextView) findViewById(R.id.time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =seconds/3600;
                int minute = (seconds%3600)/60;
                int sec = seconds%60;
                String t = String.format("%d:%02d:%02d",hours,minute,sec);
                time.setText(t);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
