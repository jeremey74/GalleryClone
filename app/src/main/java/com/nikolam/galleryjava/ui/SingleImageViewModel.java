package com.nikolam.galleryjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.nikolam.galleryjava.data.loader.ImageLoader;
import com.nikolam.galleryjava.data.loader.model.GalleryImage;

import java.util.ArrayList;

public class SingleImageViewModel extends AndroidViewModel {

    // Create a LiveData with a String
    private ArrayList<GalleryImage> images;
    int currentUrlPos;

    public SingleImageViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<GalleryImage> getAllImageUrls(){
        ImageLoader loader = new ImageLoader();

        if(images == null){
            images = new ArrayList<com.nikolam.galleryjava.data.loader.model.GalleryImage>();
        }

        images.addAll(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return images;
    }


    public void setCurrentPosition(String url) {
        for(int i = 0; i < images.size(); i++){
            if(images.get(i).getImageUrl().equals(url)){
                currentUrlPos = i;
            }
        }
    }
}