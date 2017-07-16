package com.pdm.alvaro.animalsforchild;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IncorrectoActivity extends AppCompatActivity {

    private String clasificación;
    private int milisegundos = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrecto);

        Bundle extras = getIntent().getExtras();
        clasificación = extras.getString("clasificacionAnimal");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (clasificación.equals("vertebrado")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(), AnimalesIVActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },milisegundos);

    }
}
