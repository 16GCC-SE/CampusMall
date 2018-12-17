package com.cm.vo;

/**
 * @author liaochaofan
 * @date 2018/12/16 21:51
 */
public class JImgUrlVo {
    String image_url;

    public JImgUrlVo(String mainImage) {
        image_url = mainImage;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
