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

    public ArrayList<String> selectedImages = new ArrayList<>();

    private MutableLiveData<ArrayList<GalleryImage>> imageUrlsLiveData;

    public MutableLiveData<ArrayList<GalleryImage>> getAllImages(){
        ImageLoader loader = new ImageLoader();

        if(imageUrlsLiveData == null){
            imageUrlsLiveData = new MutableLiveData<>();
        }

        imageUrlsLiveData.setValue(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        return imageUrlsLiveData;
    }

}