package com.cm.controller.backend;


import com.cm.common.Const;
import com.cm.common.ResponseCode;
import com.cm.common.ServerResponse;
import com.cm.pojo.User;
import com.cm.service.ICategoryService;
import com.cm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author liaochaofan
 * @date 2018/7/20 20:17
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId",defaultValue = "0")int parentId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
//        }
//        //校验一下是否管理员
//        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.addCategory(categoryName,parentId);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "set_category_name.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session,Integer categoryId,String categoryName){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
//        }
//        //校验一下是否管理员
//        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.updateCategoryName(categoryId,categoryName);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "get_category.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session,@RequestParam(value = "categoryId",defaultValue ="0" )Integer categoryId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
//        }
//        //校验一下是否管理员
//        if (iUserService.checkAdminRole(user).isSuccess()){
//            //查询子节点的category信息，并且不递归，保持平级
            return iCategoryService.getChildrenParallelCategory(categoryId);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "get_deep_category_id.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategoryId(HttpSession session,@RequestParam(value = "categoryId",defaultValue ="0" )Integer categoryId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //查询当前节点的id和递归子节点的id
            return iCategoryService.selectCategoryIdAndChildrenIdById(categoryId);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }
    @RequestMapping(value = "get_deep_category.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value = "categoryId",defaultValue ="0" )Integer categoryId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
//        }
//        //校验一下是否管理员
//        if (iUserService.checkAdminRole(user).isSuccess()){
//            //查询当前节点的id和递归子节点的id
            return iCategoryService.selectCategoryAndChildrenById(categoryId);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }
}
