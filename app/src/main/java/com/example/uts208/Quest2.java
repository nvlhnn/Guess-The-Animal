package com.example.uts208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Quest2 extends AppCompatActivity {

    public int totalWrong;
    public int totalRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2);

        Intent intent = getIntent();
        totalWrong = intent.getIntExtra("totalWrong",0);
        totalRight = intent.getIntExtra("totalRight",0);


    }

    public void kadal(View view) {
        wrongAnsw();

    }

    public void gajah(View view) {
        rightAnsw();

    }

    public void jerapah(View view) {
        wrongAnsw();

    }

    public void kambing(View view) {
        wrongAnsw();

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
        Intent intent = new Intent(this, Answ2.class);
        intent.putExtra("totalRight", this.totalRight);
        intent.putExtra("totalWrong", this.totalWrong);
        startActivity(intent);

    }
}