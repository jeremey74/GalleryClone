package com.nikolam.galleryjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.nikolam.galleryjava.data.loader.ImageLoader;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<String> getAllImageUrls(){
        ImageLoader loader = new ImageLoader();

        return loader.getAllShownImagesPath(getApplication().getApplicationContext());
    }

}