package com.nada.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageSlider);

        SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext());

        imageSlider.setSliderAdapter(sliderAdapter);
        imageSlider.createSlideShow();

    }
}
