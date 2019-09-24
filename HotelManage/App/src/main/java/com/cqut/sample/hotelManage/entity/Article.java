package com.cqut.sample.hotelManage.entity;

import android.os.Parcel;
import android.os.Parcelable;


public class Article implements Parcelable{
    private String title;
    private String content;
    private int imgRes;
    private String videoUrl;
    private String ImageUrl;



    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(String title, int imgRes) {
        this.title = title;
        this.imgRes = imgRes;
    }

public  Article(String videoUrl,String ImageUrl,String title){
        this.videoUrl = videoUrl;
        this.ImageUrl = ImageUrl;
        this.title = title;
}

    protected Article(Parcel in) {
        title = in.readString();
        content = in.readString();
        imgRes = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };


    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {

        return ImageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(imgRes);
    }
}
