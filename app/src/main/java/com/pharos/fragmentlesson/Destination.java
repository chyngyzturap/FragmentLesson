package com.pharos.fragmentlesson;

public class Destination {
    private String title;
    private String subTitle;
    private int imageResourceId;

    public Destination(String title, String subTitle, int imageResourceId) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageResourceId = imageResourceId;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
