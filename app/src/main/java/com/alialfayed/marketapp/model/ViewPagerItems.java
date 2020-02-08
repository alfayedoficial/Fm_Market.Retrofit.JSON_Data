package com.alialfayed.marketapp.model;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/7/2020 - 5:12 PM
 */
public class ViewPagerItems {
    private int idItem;
    private String titleItem ;
    private int imgItem;

    public ViewPagerItems(){}

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public void setTitleItem(String titleItem) {
        this.titleItem = titleItem;
    }

    public int getImgItem() { return imgItem; }

    public void setImgItem(int imgItem) {
        this.imgItem = imgItem;
    }
}
