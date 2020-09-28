package com.nikolam.galleryjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.nikolam.galleryjava.data.loader.ImageLoader;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    // Create a LiveData with a String
    private MutableLiveData<ArrayList<String>> imageUrlsLiveData;

    public MutableLiveData<ArrayList<String>> getAllImageUrls(){
        ImageLoader loader = new ImageLoader();

        if(imageUrlsLiveData == null){
            imageUrlsLiveData = new MutableLiveData<>();
        }

        imageUrlsLiveData.setValue(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return imageUrlsLiveData;
    }

}