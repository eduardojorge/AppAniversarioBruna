package com.emjorge.brunaniver;

import android.graphics.Bitmap;

public class ImageItem {
    private Bitmap image;

    private String descricao;


    public ImageItem(Bitmap image,String descricao) {
        super();
        this.image = image;
        this.descricao = descricao;

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


}
