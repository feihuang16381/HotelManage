package com.cqut.sample.hotelManage.entity;

/**
 * ${DESC}
 * author: gyq
 * create at 2016/12/12 17:02
 */
public class Fruit {
    private String name;
    private int ImageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.ImageId = imageId;
    }

    public String getName() {
        return name;
    }


    public int getImageId() {
        return ImageId;
    }

}

