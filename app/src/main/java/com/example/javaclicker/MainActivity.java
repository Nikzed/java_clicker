package com.example.javaclicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.ScaleAnimation;
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
            }
        });
    }
}
