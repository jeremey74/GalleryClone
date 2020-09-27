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
    private ImageClickListener clickListener;

    public ImageAdapter(ImageClickListener listener){
        this.clickListener = listener;
    }

    public void setImages(ArrayList<String> urls){
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
        private String url;

        public ImageViewHolder(@NonNull final GalleryImageItemBinding bind) {
            super(bind.getRoot());

            binding = bind;

            binding.getRoot().setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    clickListener.onClick(binding.getRoot(),url);
                }
            });
        }

        public void bindData(String url){
            this.url = url;
            binding.setImageUrl(url);
            binding.executePendingBindings();
        }


    }
}
