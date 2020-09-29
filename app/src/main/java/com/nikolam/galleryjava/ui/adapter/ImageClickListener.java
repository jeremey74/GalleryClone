package com.nikolam.galleryjava.ui.adapter;

import android.view.View;

public interface ImageClickListener{
     void selectedImage(final String url);
     void deselectedImage(final String url);
}
