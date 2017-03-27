package com.fushuang.assassinnews.model;

import java.util.List;

/**
 * Created by fushuang on 2017/3/27.
 */

public class StoriesBean {
    private int type;
    private int id;
    private String title;
    private List<String> images;
    private String ga_prefix;
    private boolean readState;

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public boolean isReadState() {
        return readState;
    }

    public boolean getState() {
        return readState;
    }

    public void setReadState(boolean readState) {
        this.readState = readState;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
