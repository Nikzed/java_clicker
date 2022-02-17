package com.example.javaclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import io.flutter.embedding.android.FlutterActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    ObjectAnimator scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        TextView text = findViewById(R.id.coins_text);
        text.setText("Coins: " + count);

        ImageView imageView = findViewById(R.id.imageView);

        scale = ObjectAnimator.ofPropertyValuesHolder(
                imageView,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));

        View layout = findViewById(R.id.main_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                text.setText("Coins: " + count);
                scale.setDuration(150);
                scale.setRepeatCount(ObjectAnimator.RESTART);
                scale.setRepeatMode(ObjectAnimator.REVERSE);
                scale.start();

                if (count == 10) {
                    startActivity(
                            FlutterActivity
                                    .withNewEngine()
                                    .initialRoute("/my_route")
                                    .build(MainActivity.this)
                    );
                }


            }
        });

//        startActivity(
//                FlutterActivity
//                        .withNewEngine()
//                        .initialRoute("splashRoute")
//                        .build(this)
//        );
    }
}