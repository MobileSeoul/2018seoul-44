package com.example.kccistc.seoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout seoul_place,seoul_food,seoul_festival,seoul_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seoul_place = findViewById(R.id.seoul_place);
        seoul_food = findViewById(R.id.seoul_food);
        seoul_festival = findViewById(R.id.seoul_festival);
        seoul_history = findViewById(R.id.seoul_history);

        seoul_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Place.class);
                startActivity(intent);
            }
        });

        seoul_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Food.class);
                startActivity(intent);
            }
        });

        seoul_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Festival.class);
                startActivity(intent);
            }
        });

        seoul_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });

    }
}
