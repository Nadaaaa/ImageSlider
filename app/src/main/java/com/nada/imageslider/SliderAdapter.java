package com.nada.imageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SliderAdapter extends ImageSliderAdapter<SliderAdapter.SliderAdapterViewHolder> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SliderAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image, null));
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/10/1500/1000")
                        .into(viewHolder.imageView);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "blabla", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1021/1500/1000")
                        .into(viewHolder.imageView);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1002/1500/1000")
                        .into(viewHolder.imageView);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load("https://picsum.photos/id/1000/1500/1000")
                        .into(viewHolder.imageView);
                break;

        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    class SliderAdapterViewHolder extends ImageSliderAdapter.ViewHolder {
        ImageView imageView;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}