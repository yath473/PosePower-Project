package com.posep.isometricwellness;

public class Model {

    private String imgUrl;
    private String des;
    public Model(){

    }
    public Model(String imgUrl){
        this.imgUrl = imgUrl;
        //this.des = des;

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getDescription() {
        return des;
    }

    public void setDescription(String description) {
        this.des = description;
    }
}
