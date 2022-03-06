package com.resume.maker.models;

public class TemplatesModel {
    private int imageResourse;
    private int id;

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TemplatesModel(int id, int imageResourse) {
        this.imageResourse = imageResourse;
        this.id = id;
    }
}
