package com.nada.imageslider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IndicatorAdapter extends RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder> {

    Context context;
    List<Boolean> indicators;

    @NonNull
    @Override
    public IndicatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IndicatorViewHolder holder, int position) {
       // if (indicators.get(position))
            //holder.changeIndicatorColor();

    }

    @Override
    public int getItemCount() {
        return indicators.size();
    }

    class IndicatorViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public IndicatorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void changeIndicatorColor(boolean selectedIndicator) {
            for (boolean indicator : indicators) {
                indicator = false;
                imageView.setImageDrawable(context.getDrawable(R.drawable.indicator));
                if (indicator == selectedIndicator)
                    imageView.setImageDrawable(context.getDrawable(R.drawable.selected_indicator));
            }
        }
    }
}
