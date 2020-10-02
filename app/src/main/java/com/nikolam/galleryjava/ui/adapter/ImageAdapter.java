package com.nikolam.galleryjava.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolam.galleryjava.R;
import com.nikolam.galleryjava.data.loader.model.GalleryImage;
import com.nikolam.galleryjava.databinding.GalleryImageItemBinding;
import com.nikolam.galleryjava.ui.GalleryFragmentDirections;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<GalleryImage> images = new ArrayList<>();
    private ImageClickListener clickListener;

    public ImageAdapter(ImageClickListener listener){
        this.clickListener = listener;
    }

    public void setImages(ArrayList<GalleryImage> imgs){
        this.images.addAll(imgs);
        notifyDataSetChanged();
    }

    public void currentlyIsSelecting(){
        for(GalleryImage i : images){
            i.setMisSelecting(true);
        }
        notifyDataSetChanged();
    }

    public void currentlyNotSelecting(){
        for(GalleryImage i : images){
            i.setMisSelecting(false);
        }
        notifyDataSetChanged();
    }

    public void selected(GalleryImage image){
        int k =0;
        for(GalleryImage i : images){
            if(i.getmImageUrl().equals(image.getmImageUrl())){
                i.setmSelected(true);
                break;
            }
            k++;
        }
        notifyItemChanged(k);
    }

    public void deselected(GalleryImage image){
        int k = 0;
        for(GalleryImage i : images){
            if(i.getmImageUrl().equals(image.getmImageUrl())){
                i.setmSelected(false);
                break;
            }
            k++;
        }
        notifyItemChanged(k);
    }



    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ImageViewHolder(GalleryImageItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bindData(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.gallery_image_item;
    }

    protected class ImageViewHolder extends RecyclerView.ViewHolder {

        private GalleryImageItemBinding binding;
        private String url;
        private boolean selected = false;
        private boolean isSelecting = false;
        private GalleryImage image;


        public void select(){
            selected = true;
            binding.setSelected(true);
            clickListener.selectedImage(image);
            selected(image);
            binding.executePendingBindings();
        }

        public void deselect(){

            selected = false;
            binding.setSelected(false);
            clickListener.deselectedImage(image);
            deselected(image);
            binding.executePendingBindings();
        }

        public ImageViewHolder(@NonNull final GalleryImageItemBinding bind) {
            super(bind.getRoot());
            binding = bind;
            binding.setSelected(selected);
            binding.setIsSelecting(isSelecting);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   Log.d("Images", String.valueOf(selected) + " " + isSelecting);
                    if(!selected && !isSelecting) {
                        Navigation.findNavController(v).navigate(GalleryFragmentDirections.actionGalleryFragmentToSingleImageFragment(url));
                    } else if(!selected && isSelecting){ // and selecting, select
                        select();
                    } else { // selected and selecting is true, deselect
                        deselect();
                    }
                }
            });


            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(!selected) {
                        select();
                    } else {
                        deselect();
                    }

                    return true;
                }
            });


        }

        public void bindData(GalleryImage image){
            this.image = image;
            this.url = image.getmImageUrl();
            this.isSelecting = image.isMisSelecting();
            this.selected = image.ismSelected();
            binding.setImageUrl(url);
            binding.setSelected(selected);
            binding.setIsSelecting(isSelecting);
            binding.executePendingBindings();
        }


    }
}
