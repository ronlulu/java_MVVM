package com.ronlu.mvvm_movie.viewModels.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.ronlu.mvvm_movie.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView recyclerview_LBL_title;
    TextView recyclerview_LBL_genre;
    TextView recyclerview_LBL_year;
    TextView recyclerview_LBL_rate;
    AppCompatImageView recyclerview_IMG_poster;

    public ViewHolder(@NonNull View view) {
        super(view);
        recyclerview_LBL_title = view.findViewById(R.id.recyclerview_LBL_title);
        recyclerview_LBL_genre = view.findViewById(R.id.recyclerview_LBL_genre);
        recyclerview_LBL_year = view.findViewById(R.id.recyclerview_LBL_year);
        recyclerview_LBL_rate = view.findViewById(R.id.recyclerview_LBL_rate);
        recyclerview_IMG_poster = view.findViewById(R.id.recyclerview_IMG_poster);
    }
}
