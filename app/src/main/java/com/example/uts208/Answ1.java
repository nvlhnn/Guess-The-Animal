package com.example.uts208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Answ1 extends AppCompatActivity {

    int totalRight;
    int totalWrong;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answ1);

        Intent intent = getIntent();
        mp = MediaPlayer.create(this, R.raw.giraffe);
        totalWrong = intent.getIntExtra("totalWrong",0);
        totalRight = intent.getIntExtra("totalRight",0);
    }

    public void read(View view) {
        stopP();
        Uri webpage = Uri.parse("https://id.wikipedia.org/wiki/Jerapah");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    public void next(View view) {
        stopP();
        this.totalRight = this.totalRight + 1;
        String log = String.valueOf(this.totalRight);
        Log.d("jawaban benar", log);
        Intent intent = new Intent(this, Quest2.class);
        intent.putExtra("totalRight", this.totalRight);
        intent.putExtra("totalWrong", this.totalWrong);
        startActivity(intent);
    }

    public void play(View view) {
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.giraffe);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }

    }

    public void stopP(){
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.giraffe);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}