package com.roqua;

class AuthorsItem {
    public int image;
    public String author_name;
    public String roqia_url;
    public String harq_url;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getRoqia_url() {
        return roqia_url;
    }

    public void setRoqia_url(String roqia_url) {
        this.roqia_url = roqia_url;
    }

    public String getHarq_url() {
        return harq_url;
    }

    public void setHarq_url(String harq_url) {
        this.harq_url = harq_url;
    }

    public AuthorsItem(int image, String author_name, String roqia_url, String harq_url) {
        this.image = image;
        this.author_name = author_name;
        this.roqia_url = roqia_url;
        this.harq_url = harq_url;
    }
}
