package com.marcelo.calculadoraimc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Imcactivity extends AppCompatActivity {

    AppCompatButton mrecalculatebmi;

    TextView mimcdisplay, mimccategory, mgender;
    Intent intent;
    ImageView mimageview;
    String mimc;
    float intimc;

    String height, weight;
    float intheight, intweight;
    RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Resultado");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        mrecalculatebmi = findViewById(R.id.recalculatebmi);
        mimcdisplay = findViewById(R.id.imcdisplay);
        mimccategory = findViewById(R.id.imccategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mimageview = findViewById(R.id.imageview);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;

        intimc = intweight / (intheight * intheight);

        mimc = String.format("%.02f", intimc);

        if (intimc < 16.9) {
            mimccategory.setText("Muito abaixo do peso");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intimc > 17 && intimc < 18.4) {
            mimccategory.setText("Abaixo do peso");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intimc > 18.5 && intimc < 24.9) {
            mimccategory.setText("Peso normal");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        } else if (intimc > 25 && intimc < 29.9) {
            mimccategory.setText("Acima do peso");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intimc > 30 && intimc < 34.9) {
            mimccategory.setText("Obesidade Grau I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intimc > 35 && intimc < 40) {
            mimccategory.setText("Obesidade Grau II");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intimc > 40) {
            mimccategory.setText("Obesidade Grau III");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mimcdisplay.setText(mimc);

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