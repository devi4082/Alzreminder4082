package com.example.reyna.alzreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class addTaskActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbartask);
        setSupportActionBar(toolbar);

        ArrayList<DataListTask> dataListTasks = new ArrayList<>();
        dataListTasks.add(new DataListTask(getIntent().getStringExtra("TITLE"), getIntent().getStringExtra("DESC"), getIntent().getStringExtra("CLOCK"), getIntent().getStringExtra("DATE")));

        ListAdapterTask arrayAdapter = new ListAdapterTask(this, dataListTasks);
        ListView listView  = (ListView) findViewById(R.id.itemReminder);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent item1 = new Intent(addTaskActivity.this, viewTaskActivity.class);
                        startActivity(item1);
                        break;
                }
            }
        });
    }
    public void addTask(View view){
        ImageView imageView = (ImageView) findViewById(R.id.add);
        Intent intent = new Intent(addTaskActivity.this, nextTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(addTaskActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
}
