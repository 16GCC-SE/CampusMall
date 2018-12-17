package com.cm.vo;

import java.math.BigDecimal;

/**
 * @author liaochaofan
 * @date 2018/12/15 21:12
 */
public class JProductVo {
    private Integer product_id;
    private String product_name;
    private BigDecimal product_price;
    private String product_detail;

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

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }
}
