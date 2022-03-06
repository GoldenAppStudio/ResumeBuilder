package com.resume.maker.models;

import org.intellij.lang.annotations.Language;

public class SecondaryDetailsModel {
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SecondaryDetailsModel() {
    }

    public SecondaryDetailsModel(String data) {
        this.data = data;
    }
}