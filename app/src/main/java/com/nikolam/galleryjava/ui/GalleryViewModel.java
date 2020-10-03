package com.nikolam.galleryjava.ui;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.nikolam.galleryjava.data.loader.ImageLoader;
import com.nikolam.galleryjava.data.loader.model.GalleryImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    // Create a LiveData with a String
    private MutableLiveData<ArrayList<GalleryImage>> imagesLiveData = new MutableLiveData<>();;
    private ArrayList<GalleryImage> images = new ArrayList<>();

    public ArrayList<GalleryImage> selectedImages = new ArrayList<>();

    public MutableLiveData<ArrayList<GalleryImage>> getAllImages(){
        ImageLoader loader = new ImageLoader();

        images.addAll(loader.getAllShownImagesPath(getApplication().getApplicationContext()));

        imagesLiveData.setValue(images);

        return imagesLiveData;
    }


    public void deleteSelectedImages(){
        for(GalleryImage img : selectedImages){
            File file = new File(img.getmImageUrl());
            if(!file.exists()) {
                return;
            }

            String canonicalPath;
            ContentResolver contentResolver = getApplication().getContentResolver();
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException e) {
                canonicalPath = file.getAbsolutePath();
            }
            final Uri uri = MediaStore.Files.getContentUri("external");
            final int result = contentResolver.delete(uri,
                    MediaStore.Files.FileColumns.DATA + "=?", new String[]{canonicalPath});
            if (result == 0) {
                final String absolutePath = file.getAbsolutePath();
                if (!absolutePath.equals(canonicalPath)) {
                    contentResolver.delete(uri,
                            MediaStore.Files.FileColumns.DATA + "=?", new String[]{absolutePath});
                }
            }

            images.remove(img);
        }

        imagesLiveData.setValue(images);
        selectedImages.clear();
        Toast.makeText(getApplication().getApplicationContext(), "Succesfully deleted image(s)", Toast.LENGTH_SHORT).show();
    }

    public void clearData(){
        selectedImages.clear();
        images.clear();
        imagesLiveData.setValue(images);
    }


}