package com.example.administrator.power;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nourish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nourish);

        Button Disease = (Button)findViewById(R.id.buttonDisease);
        Disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,disease.class);
                startActivity(intent);
            }
        });

        Button Inscet = (Button)findViewById(R.id.buttonInscet);
        Inscet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this, insect.class);
                startActivity(intent);
            }
        });

        Button Weed = (Button)findViewById(R.id.buttonWeed);
        Weed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,weed.class);
                startActivity(intent);
            }
        });

        Button Fertilizer = (Button)findViewById(R.id.buttonFertilizar);
        Fertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,fertilizer.class);
                startActivity(intent);
            }
        });

        Button Price = (Button)findViewById(R.id.buttonPrice);
        Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,price.class);
                startActivity(intent);
            }
        });

    }
}
