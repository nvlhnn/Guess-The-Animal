package com.example.uts208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Quest1 extends AppCompatActivity {
    public int totalWrong = 0;
    public int totalRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest1);
    }


    public void kadal(View view) {
        wrongAnsw();

    }

    public void gajah(View view) {

        wrongAnsw();
    }

    public void jerapah(View view) {

        rightAnsw();
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
        Intent intent = new Intent(this, Answ1.class);
        intent.putExtra("totalRight", this.totalRight);
        intent.putExtra("totalWrong", this.totalWrong);
        startActivity(intent);

    }


}