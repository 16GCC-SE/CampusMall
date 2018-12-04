package com.cm.service;


import com.cm.common.ServerResponse;
import com.cm.pojo.Shipping;
import com.github.pagehelper.PageInfo;

/**
 * @author liaochaofan
 * @date 2018/7/29 22:58
 */
public interface IShippingService{
    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId,Integer shippingId);

    ServerResponse update(Integer userId,Shipping shipping);

    ServerResponse<Shipping> select(Integer userId,Integer shippingId);

    ServerResponse<PageInfo> list(int pageNum, int pageSize, Integer userId);
}
