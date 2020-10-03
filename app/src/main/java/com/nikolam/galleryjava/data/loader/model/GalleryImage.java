package com.nikolam.galleryjava.data.loader.model;

import android.net.Uri;

public class GalleryImage {
    private boolean mSelected;
    private boolean misSelecting;
    private String mImageUrl;
    private Uri contentUri;

    public GalleryImage(boolean mSelected, boolean misSelecting, String mImageUrl, Uri contentUri) {
        this.mSelected = mSelected;
        this.misSelecting = misSelecting;
        this.mImageUrl = mImageUrl;
        this.contentUri = contentUri;
    }

    public Uri getContentUri() {
        return contentUri;
    }

    public void setContentUri(Uri contentUri) {
        this.contentUri = contentUri;
    }

    public boolean ismSelected() {
        return mSelected;
    }

    public void setmSelected(boolean mSelected) {
        this.mSelected = mSelected;
    }

    public boolean isMisSelecting() {
        return misSelecting;
    }

    public void setMisSelecting(boolean misSelecting) {
        this.misSelecting = misSelecting;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

}
