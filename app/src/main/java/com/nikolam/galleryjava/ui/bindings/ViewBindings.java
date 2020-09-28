package com.nikolam.galleryjava.ui.bindings;

import android.util.Log;
import android.view.View;
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

    @BindingAdapter("selected")
    public static void imageViewSelection(ImageView view, boolean selected) {
       if(selected){
           view.setVisibility(View.VISIBLE);
       } else {
           view.setVisibility(View.INVISIBLE);
       }
    }

}

