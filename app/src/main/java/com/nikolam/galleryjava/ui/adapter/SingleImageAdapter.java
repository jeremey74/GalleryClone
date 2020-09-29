package com.nikolam.galleryjava.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.nikolam.galleryjava.data.loader.model.GalleryImage;

import java.util.ArrayList;

public class SingleImageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<GalleryImage> images;

    public void setImages(ArrayList<GalleryImage> imageUrls){
        this.images = imageUrls;
    }

    public SingleImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(images.get(position).getImageUrl()).into(imageView);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(((ImageView) object));
    }

}
