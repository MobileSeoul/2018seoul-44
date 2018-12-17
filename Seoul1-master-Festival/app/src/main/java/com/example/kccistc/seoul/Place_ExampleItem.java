package com.example.kccistc.seoul;

public class Place_ExampleItem {

    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    private String mAddress;
    private double mLat;
    private double mLng;
    private String mContentid;

    public Place_ExampleItem(String imageUrl, String contentid, String creator, int likes, String address, double lat, double lng) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
        mAddress = address;
        mLat = lat;
        mLng = lng;
        mContentid = contentid;
    }

//    public Place_ExampleItem(String imageUrl, String contentid, String creatorName, int likeCount, String address, double lat, double lng) {
//    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getContentid() {
        return mContentid;
    }

    public int getLikeCount() {
        return mLikes;
    }

    public String getAddress() {
        return mAddress;
    }

    public double getLat() {
        return mLat;
    }

    public double getLng() {
        return mLng;
    }
}
