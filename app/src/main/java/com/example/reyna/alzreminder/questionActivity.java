package com.example.reyna.alzreminder;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class questionActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        radioGroup = (RadioGroup) findViewById(R.id.radioGrp);
    }
    public void onRadioButton (View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButton:
                if (checked)
                    tampilDialog();
                break;

            case R.id.radioButton2:
                if (checked)
                    tampilDialog();
                break;
            case R.id.radioButton3:
                if (checked)
                    tampilDialog();
                break;
        }
    }
    public void tampilDialog(){
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Selamat!");
        builder.setMessage("Score : 10");
        builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(questionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.create().show();
    }
    @Override
    public void onBackPressed() {

    }
}
