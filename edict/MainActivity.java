package com.example.arun_thomas.edict;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
                finish();
            }
        }, 3000);





    }
}