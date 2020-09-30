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
    int currentPos;

    public SingleImageViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<GalleryImage> getAllImages(){
        ImageLoader loader = new ImageLoader();

        if(images == null){
            images = new ArrayList<>();
        }

        images.addAll(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return images;
    }


    public void setCurrentPosition(String url) {
        int k = 0;
        for(GalleryImage i : images){
            if(i.getmImageUrl().equals(url)){
                currentPos = k;
                break;
            }
            k++;
        }
    }
}