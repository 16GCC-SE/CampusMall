package com.cm.vo;

import java.math.BigDecimal;

/**
 * @author liaochaofan
 * @date 2018/12/15 17:28
 */
public class JCartVo {
   private Integer cart_id;
   private Integer user_id;
   private Integer product_id;
   private String product_name;
   private BigDecimal product_uprice;
   private String product_img_url;
   private Integer goods_num;
   private Integer product_num;
   private String shop_name;

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getProduct_uprice() {
        return product_uprice;
    }

    public void setProduct_uprice(BigDecimal product_uprice) {
        this.product_uprice = product_uprice;
    }

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public Integer getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Integer product_num) {
        this.product_num = product_num;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
}
