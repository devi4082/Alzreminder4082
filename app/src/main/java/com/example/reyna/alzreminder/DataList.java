package com.example.reyna.alzreminder;

/**
 * Created by reyna on 3/14/2018.
 */

public class DataList {
    public String title;
    public String description;
    public int gambar=NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED=-1;

    public DataList(String title, String description, int gambar) {
        this.title = title;
        this.description = description;
        this.gambar = gambar;
    }

    public DataList(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getGambar() {
        return gambar;
    }
    public boolean hasImage(){
        return gambar!=NO_IMAGE_PROVIDED;
    }
}
