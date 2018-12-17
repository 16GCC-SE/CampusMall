package com.cm.vo;

import java.math.BigDecimal;

/**
 * @author liaochaofan
 * @date 2018/12/12 20:08
 */
public class JHomeVo {
    private Integer product_id;
    private String product_name;
    private BigDecimal product_price;
    private String product_img_url;
    private BigDecimal product_uprice;

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

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }

    public BigDecimal getProduct_uprice() {
        return product_uprice;
    }

    public void setProduct_uprice(BigDecimal product_uprice) {
        this.product_uprice = product_uprice;
    }
}
