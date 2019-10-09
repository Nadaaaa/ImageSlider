package com.nada.imageslider;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;


public class ImageSlider extends FrameLayout {

    ImageSliderAdapter imageSliderAdapter;
    ViewPager viewPager;
    int currentPosition = 0;

    public ImageSlider(@NonNull Context context) {
        super(context);
        setupSlideView(context);
    }

    public ImageSlider(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupSlideView(context);
    }

    private void setupSlideView(Context context) {

        View rootView = LayoutInflater
                .from(context)
                .inflate(R.layout.layout_slider_view, this, true);

        viewPager = rootView.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(5);
    }

    public void setSliderAdapter(final ImageSliderAdapter imageSliderAdapter) {
        this.imageSliderAdapter = imageSliderAdapter;
        viewPager.setAdapter(imageSliderAdapter);
    }

    void createSlideShow() {

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPosition == imageSliderAdapter.getCount())
                    currentPosition = 0;
                viewPager.setCurrentItem(currentPosition++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 200, 2500);
    }

}
