package com.nikolam.galleryjava.ui.adapter;

import android.view.View;

import com.nikolam.galleryjava.data.loader.model.GalleryImage;

public interface ImageClickListener{
     void selectedImage(final GalleryImage image);
     void deselectedImage(final GalleryImage image);
}
