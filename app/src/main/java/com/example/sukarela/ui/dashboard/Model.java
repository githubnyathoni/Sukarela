package com.example.sukarela.ui.dashboard;

public class Model {
    int image;
    String name, about;

    public Model(int image, String name, String about){
        this.image = image;
        this.name = name;
        this.about = about;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
