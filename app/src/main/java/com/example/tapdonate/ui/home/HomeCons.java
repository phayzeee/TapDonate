package com.example.tapdonate.ui.home;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeCons {
    private String t1,t2;
    private String btn_image;
    private int logoImage;

    public String getBtn_image() {
        return btn_image;
    }

    public HomeCons(String btn_image) {
        this.btn_image = btn_image;
    }

    public void setBtn_image(String btn_image) {
        this.btn_image = btn_image;
    }

    public HomeCons(String t1, String t2, int logoImage) {
        this.t1 = t1;
        this.t2 = t2;
        this.logoImage = logoImage;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(int logoImage) {
        this.logoImage = logoImage;
    }
}
