package com.countingapp;

import android.widget.Toast;

public class OddCounting implements Runnable{

    private MainActivity activity;
    public OddCounting(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        for (int i= 1; i <= 100; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            String message = "Even Count complete";
            Toast.makeText(activity,message, Toast.LENGTH_LONG).show();
        }
    });
}
