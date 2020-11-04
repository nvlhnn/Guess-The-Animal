package com.example.uts208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Quest3 extends AppCompatActivity {

    public int totalWrong;
    public int totalRight;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest3);

        mp = MediaPlayer.create(this, R.raw.goat);
        Intent intent = getIntent();
        totalWrong = intent.getIntExtra("totalWrong",0);
        totalRight = intent.getIntExtra("totalRight",0);


    }

    public void kadal(View view) {
        stopP();
        wrongAnsw();

    }

    public void gajah(View view) {
        stopP();
        wrongAnsw();
    }

    public void jerapah(View view) {
        stopP();
        wrongAnsw();

    }

    public void kambing(View view) {
        stopP();
        rightAnsw();



    }

    public void wrongAnsw(){
        Toast.makeText(this, "Yahhh jawaban kamu masih salah!", Toast.LENGTH_SHORT).show();
        this.totalWrong = this.totalWrong + 1;
        String log = String.valueOf(this.totalWrong);
        Log.d("jawabab salah", log);


    }

    public void rightAnsw(){

        Toast.makeText(this, "Yeeee jawaban kamu benar!", Toast.LENGTH_SHORT).show();
        this.totalRight = this.totalRight + 1;
        String log = String.valueOf(this.totalRight);
        Log.d("jawaban benar", log);
        Intent intent = new Intent(this, Answ3.class);
        intent.putExtra("totalRight", this.totalRight);
        intent.putExtra("totalWrong", this.totalWrong);
        startActivity(intent);

    }

    public void play(View view) {
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.goat);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void stopP(){
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.goat);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}