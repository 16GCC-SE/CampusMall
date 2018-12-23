package com.cm.service;


import com.cm.common.ServerResponse;
import com.cm.pojo.Category;

import java.util.List;

/**
 * @author liaochaofan
 * @date 2018/7/21 9:19
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId,String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer caregoryId);

    ServerResponse<List<Integer>> selectCategoryIdAndChildrenIdById(Integer categoryId);

    ServerResponse<List<Category>> selectCategoryAndChildrenById(Integer categoryId);
}


