package com.nikolam.galleryjava.data.loader.model;

public class GalleryImage {
    private boolean mSelected;
    private boolean misSelecting;
    private String mImageUrl;
    private String contentUri;

    public GalleryImage(boolean mSelected, boolean misSelecting, String mImageUrl, String contentUri) {
        this.mSelected = mSelected;
        this.misSelecting = misSelecting;
        this.mImageUrl = mImageUrl;
        this.contentUri = contentUri;
    }

    public String getContentUri() {
        return contentUri;
    }

    public void setContentUri(String contentUri) {
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
