package com.nikolam.galleryjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.nikolam.galleryjava.data.loader.ImageLoader;

import java.util.ArrayList;

public class SingleImageViewModel extends AndroidViewModel {

    // Create a LiveData with a String
    private ArrayList<String> imageUrls;
    int currentUrlPos;

    public SingleImageViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<String> getAllImageUrls(){
        ImageLoader loader = new ImageLoader();

        if(imageUrls == null){
            imageUrls = new ArrayList<>();
        }

        imageUrls.addAll(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return imageUrls;
    }


    public void setCurrentPosition(String url) {
        currentUrlPos = imageUrls.indexOf(url);
    }
}