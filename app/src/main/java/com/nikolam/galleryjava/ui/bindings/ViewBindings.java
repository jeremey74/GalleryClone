package com.nikolam.galleryjava.ui.bindings;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class ViewBindings {
    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view)
                .load(imageUrl)
                .centerCrop()
                .into(view);
    }

    @BindingAdapter("adapter")
    public static void adapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
}

