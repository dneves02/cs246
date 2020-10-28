package com.countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countOdds(View view) {
        OddCounting oddRunnable = new OddCounting(this);
        Thread oddThread = new Thread(oddRunnable);
        oddThread.start();
    }
    public void countEvens(View view) {
        EvenCounting evenRunnable = new EvenCounting(this);
        Thread evenThread = new Thread(evenRunnable);
        evenThread.start();
    }
}