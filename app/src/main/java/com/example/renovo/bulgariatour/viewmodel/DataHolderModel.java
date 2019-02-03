package com.example.renovo.bulgariatour.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

public class DataHolderModel {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @SuppressLint("StaticFieldLeak")
    private static DataHolderModel mInstance;

    private int[] imageHistoryRes;
    private int[] dataHistoryDesc;
    private int[] titleHistoryDesc;
    private int[] licenseHistoryDesc;
    private int[] imageRes;
    private int[] dataDesc;
    private int[] titleDesc;
    private int mPos;

    private DataHolderModel(Context context){
        mContext = context;
    }

    public int[] getHistoryTitleDesc() {return titleHistoryDesc;}
    public void setHistoryTitleDesc(int[] titles) {this.titleHistoryDesc = titles;}

    public int[] getHistoryDataDesc() {return dataHistoryDesc;}
    public void setHistoryDataDesc(int[] data) {this.dataHistoryDesc = data;}

    public int[] getHistoryLicenseDesc() {return licenseHistoryDesc;}
    public void setHistoryLicenseDesc(int[] license) {this.licenseHistoryDesc = license;}

    public int[] getHistoryImageDesc() {return imageHistoryRes;}
    public void setHistoryImageDesc(int[] image) {this.imageHistoryRes = image;}

    public int[] getImageRes() {return imageRes;}
    public void setImageRes(int[] image) {this.imageRes = image;}

    public int[] getDataDesc() {return dataDesc;}
    public void setDataDesc(int[] data) {this.dataDesc = data;}

    public int[] getTitleDesc() {return titleDesc;}
    public void setTitleDesc(int[] titles) {this.titleDesc = titles;}

    public int getPos() {return mPos;}
    public void setPos(int pos) {this.mPos = pos;}

    public static synchronized DataHolderModel getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DataHolderModel(context);
        }
        return mInstance;
    }
}
