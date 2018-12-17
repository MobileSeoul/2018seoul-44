package com.example.kccistc.seoul;

public class ExampleItem {


    private String mImageUrl;
    private String mCreator;
    private String mAddres;
    private String mInfo;
    private String mPhone;
    private String mTime;
    private String mMenu;
    private String mMenu1;
    private String mMenu2;

    public ExampleItem(String imageUrl, String creator, String addres, String info,
                       String phone, String time, String menu, String menu1, String menu2) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mAddres = addres;
        mInfo = info;
        mPhone = phone;
        mTime = time;
        mMenu = menu;
        mMenu1 = menu1;
        mMenu2 = menu2;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public String getmAddres() {
        return mAddres;
    }
    public String getmInfo() {
        return mInfo;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmMenu() {
        return mMenu;
    }
    public String getmMenu1() { return mMenu1; }

    public String getmMenu2() { return mMenu2; }
}