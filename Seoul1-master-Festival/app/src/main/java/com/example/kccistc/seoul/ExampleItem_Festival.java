package com.example.kccistc.seoul;

public class ExampleItem_Festival {

    private String mImageUrl;
    private String mCreator;
    private String mPlace;


    private String mTime;

    public String getmPeriod() {
        return mPeriod;
    }

    private String mPeriod;

    private String mPay;
    private String mInqury;
    private String mLink;


    public ExampleItem_Festival(String mImageUrl, String mCreator, String mPlace, String mPeriod, String mTime, String mPay, String mInqury, String mLink) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mPlace = mPlace;
        this.mTime = mTime;
        this.mPay = mPay;
        this.mInqury = mInqury;
        this.mLink = mLink;

        this.mPeriod = mPeriod;
    }


    public String getmPay() {
        return mPay;
    }

    public String getmInqury() {
        return mInqury;
    }

    public String getmLink() {
        return mLink;
    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTime() {
        return mTime;
    }


}
