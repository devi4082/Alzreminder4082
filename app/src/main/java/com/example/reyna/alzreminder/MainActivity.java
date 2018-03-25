package com.example.reyna.alzreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.nextTask);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextTask = new Intent(MainActivity.this, addTaskActivity.class);
                startActivity(nextTask);
            }
        });
        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.myMoment);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myMoment = new Intent(MainActivity.this, myMomentActivity.class);
                startActivity(myMoment);
            }
        });
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.remember);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remember = new Intent(MainActivity.this, rememberActivity.class);
                startActivity(remember);
            }
        });
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.progress);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent progress = new Intent(MainActivity.this, progressActivity.class);
                startActivity(progress);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
