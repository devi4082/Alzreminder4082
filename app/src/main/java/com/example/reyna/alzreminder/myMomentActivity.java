package com.example.reyna.alzreminder;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class myMomentActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moment);

        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbartask);
        setSupportActionBar(toolbar);

        ArrayList<DataList> list = new ArrayList<>();
        int[] image = {R.drawable.ic_face_red_48dp, R.drawable.ic_face_blue_48dp};


        list.add(new DataList(getIntent().getStringExtra("TITLE"), getIntent().getStringExtra("DESC"), image[1]));

        ListAdapter itemAdapter=new ListAdapter(this, list);
        final ListView listlist = (ListView) findViewById(R.id.list_item);
        listlist.setAdapter(itemAdapter);
        listlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), viewMomentActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tambahMemori(View view) {
        ImageView img = (ImageView) findViewById(R.id.plus);
        Intent i = new Intent(myMomentActivity.this, addMomentActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(myMomentActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
}
