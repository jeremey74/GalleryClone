package com.nikolam.galleryjava.ui.bindings;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

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

    @BindingAdapter("selectedImageView")
    public static void selectedImageView(ImageView view, boolean selected) {
       if(selected){
           view.setScaleX(0.7f);
           view.setScaleY(0.7f);
       } else {
           view.setScaleX(1.0f);
           view.setScaleY(1.0f);
       }
    }

    @BindingAdapter("selectedRadioButton")
    public static void selectedRadioButton(RadioButton view, boolean selected) {
        if(selected){
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

}

