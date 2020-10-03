package com.nikolam.galleryjava.data.loader;

import android.app.Activity;
import android.content.ContentUris;
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
        int column_index_data, column_index_content_uri;
        ArrayList<GalleryImage> listOfAllImages = new ArrayList<GalleryImage>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Video.Media._ID,
                MediaStore.MediaColumns.DATA

        };

        cursor = context.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);


        while (cursor.moveToNext()) {
            long id = cursor.getLong(idColumn);
            absolutePathOfImage = cursor.getString(column_index_data);

            Uri contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);

            listOfAllImages.add(new GalleryImage(false, false , absolutePathOfImage, contentUri));
        }


        cursor.close();

        return listOfAllImages;
    }
}
