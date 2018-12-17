package com.cm.service;

import org.springframework.stereotype.Service;

/**
 * @author liaochaofan
 * @date 2018/12/12 20:18
 */

public interface IWholeService {
    public String getHomeDatas();

    public String getCategory();

    public String getCategoryGoods(Integer mId);

    public String login(String username, String password);

    public String getUserInfo(Integer uId);

    public String getCart(Integer uId);

    public String getProductDetail(Integer mId);

    public String register(String username, String password);
}
