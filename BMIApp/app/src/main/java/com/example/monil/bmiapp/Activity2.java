package com.example.monil.bmiapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

    }
    public void calculate(View view)
    {
        double ht = 0;
        double wgt = 0;
        double ans = 0;
        EditText weight = (EditText) findViewById(R.id.weight);
        EditText height = (EditText) findViewById(R.id.height);
        TextView answer = (TextView) findViewById(R.id.answer);
        TextView conclusion = (TextView) findViewById(R.id.conclusion);
        wgt = Double.parseDouble(weight.getText().toString());
        ht = Double.parseDouble(height.getText().toString());
        ans = wgt/(ht*ht);
        answer.setText(String.valueOf(ans));
        if(ans<18.5)
            conclusion.setText("UNDERWEIGHT");
        else if(ans>=18.5 && ans<25)
            conclusion.setText("NORMAL");
        else if(ans>=25 && ans<=30)
            conclusion.setText("OVERWEIGHT");
        else
            conclusion.setText("OBESE");

    }

}
