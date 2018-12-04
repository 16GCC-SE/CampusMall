package com.cm.controller.portal;

import com.cm.common.ServerResponse;
import com.cm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liaochaofan
 * @date 2018/12/4 10:33
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;


    @RequestMapping("/get_category_name.do")
    @ResponseBody
    public ServerResponse getCategoryName(@RequestParam(value = "categoryId",defaultValue ="0" )Integer categoryId){
        return iCategoryService.getChildrenParallelCategory(categoryId);
    }


}
