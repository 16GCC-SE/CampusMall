package com.cm.service;


import com.cm.common.ServerResponse;
import com.cm.pojo.Product;
import com.cm.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

/**
 * @author liaochaofan
 * @date 2018/7/22 12:52
 */
public interface IProductService {
    ServerResponse saveOrProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);
}
