package com.example.tablayoutclick;

public class Chat {
    private String Name,Num;
    private int Photo;

    public Chat(String name, String num, int photo) {
        Name = name;
        Photo = photo;
        Num=num;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
