package com.nikolam.galleryjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.nikolam.galleryjava.data.loader.ImageLoader;
import com.nikolam.galleryjava.data.loader.model.GalleryImage;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    // Create a LiveData with a String
    private MutableLiveData<ArrayList<GalleryImage>> imagesLiveData;

    public ArrayList<GalleryImage> selectedImages = new ArrayList<>();

    public MutableLiveData<ArrayList<GalleryImage>> getAllImages(){
        ImageLoader loader = new ImageLoader();

        if(imagesLiveData == null){
            imagesLiveData = new MutableLiveData<>();
        }

        imagesLiveData.setValue(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return imagesLiveData;
    }

}