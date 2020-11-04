package com.example.uts208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    public int totalWrong;
    TextView mWrong, mSug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();
        totalWrong = intent.getIntExtra("totalWrong",0);
        mWrong = findViewById(R.id.tv_wrong);
        mSug = findViewById(R.id.tv_sug);

        String tW = String.valueOf(totalWrong);
        mWrong.setText(tW + "x");

        if(totalWrong>3){
            mSug.setText("Belajar Lagi Yaaaa.");
        }else {
            mSug.setText("Pertahankan dan Tingkatkan Terus Kemampuanmu!");
        }

    }

    public void find(View view) {

        Uri addressUri = Uri.parse("geo:0,0?q=" + "Kebun binatang");

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}