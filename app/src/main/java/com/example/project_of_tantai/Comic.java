package com.example.project_of_tantai;

public class Comic {
    int id;
    String namecomic;
    String imagecomic;
    String artistcomic;
    String contentcomic;

    public Comic(int id, String namecomic, String imagecomic, String artistcomic, String contentcomic) {
        this.id = id;
        this.namecomic = namecomic;
        this.imagecomic = imagecomic;
        this.artistcomic = artistcomic;
        this.contentcomic = contentcomic;
    }

    public Comic(String namecomic, String imagecomic, String artistcomic, String contentcomic) {
        this.namecomic = namecomic;
        this.imagecomic = imagecomic;
        this.artistcomic = artistcomic;
        this.contentcomic = contentcomic;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecomic() {
        return namecomic;
    }

    public void setNamecomic(String namecomic) {
        this.namecomic = namecomic;
    }

    public String getImagecomic() {
        return imagecomic;
    }

    public void setImagecomic(String imagecomic) {
        this.imagecomic = imagecomic;
    }

    public String getArtistcomic() {
        return artistcomic;
    }

    public void setArtistcomic(String artistcomic) {
        this.artistcomic = artistcomic;
    }

    public String getContentcomic() {
        return contentcomic;
    }

    public void setContentcomic(String contentcomic) {
        this.contentcomic = contentcomic;
    }

}
