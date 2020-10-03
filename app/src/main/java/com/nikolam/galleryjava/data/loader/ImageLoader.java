package com.nikolam.galleryjava.data.loader;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.nikolam.galleryjava.data.loader.model.GalleryImage;

import java.util.ArrayList;

public class ImageLoader {
    public ArrayList<GalleryImage> getAllShownImagesPath(Context context) {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name, column_index_content_uri;
        ArrayList<GalleryImage> listOfAllImages = new ArrayList<GalleryImage>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,

        };

        cursor = context.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(new GalleryImage(false, false , absolutePathOfImage, ""));
        }


        cursor.close();

        return listOfAllImages;
    }
}
