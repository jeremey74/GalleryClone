package com.nikolam.galleryjava.ui.adapter;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolam.galleryjava.R;
import com.nikolam.galleryjava.databinding.GalleryImageItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> imageUrls = new ArrayList<>();

    public void setImages(ArrayList<String> urls){
        Log.d("Images", urls.toString());
        this.imageUrls.addAll(urls);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Images", "Create");
       return new ImageViewHolder(GalleryImageItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Log.d("Images", "bind");
        holder.bindData(imageUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.gallery_image_item;
    }

    protected class ImageViewHolder extends RecyclerView.ViewHolder {

        private GalleryImageItemBinding binding;

        public ImageViewHolder(@NonNull GalleryImageItemBinding bind) {
            super(bind.getRoot());
            binding = bind;
        }

        public void bindData(String url){
            Log.d("BindData", url);
            binding.setImageUrl(url);
            binding.executePendingBindings();
        }


    }
}
