package com.pdm.alvaro.animalsforchild;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CorrectoActivity extends AppCompatActivity {

    private String tipoAnimal, clasificación;
    private TextView tipo;
    private  int milisegundos = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correcto);

        tipo = (TextView) findViewById(R.id.tipoAnimal);

        Bundle extras = getIntent().getExtras();

        tipoAnimal = extras.getString("tipoAnimal");
        clasificación = extras.getString("clasificacionAnimal");
        tipo.setText(tipoAnimal);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.aplausos);
        mediaPlayer.start();

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
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        },milisegundos);

    }
}
