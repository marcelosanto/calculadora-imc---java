package com.marcelo.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Imcactivity extends AppCompatActivity {

    AppCompatButton mrecalculatebmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        getSupportActionBar().hide();

        mrecalculatebmi = findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Imcactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}