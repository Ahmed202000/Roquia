package com.roqua;

class AuthorItem {
    String type;
    String name;
    int image;
    String song_url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public AuthorItem(String type, String name, int image, String song_url) {
        this.type = type;
        this.name = name;
        this.image = image;
        this.song_url = song_url;
    }
}
