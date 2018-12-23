package com.cm.controller.backend;

import com.cm.common.Const;
import com.cm.common.ResponseCode;
import com.cm.common.ServerResponse;
import com.cm.pojo.Product;
import com.cm.pojo.User;
import com.cm.service.IFileService;
import com.cm.service.IProductService;
import com.cm.service.IUserService;
import com.cm.util.PropertiesUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author liaochaofan
 * @date 2018/7/22 12:24
 */
@Controller
@RequestMapping("/manage/product/")
public class ProductManageController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IFileService iFileService;

    @RequestMapping(value = "save.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iProductService.saveOrProduct(product);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping(value = "save_sale_status.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession session, Integer productId,Integer status){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iProductService.setSaleStatus(productId, status);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping(value = "detail.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //填充业务
            return iProductService.manageProductDetail(productId);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    //后台
    @RequestMapping(value = "list.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getList(HttpServletResponse response,HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //填充业务
            return iProductService.getProductList(pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping(value = "search.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse productSearch(HttpSession session,String productName,Integer productId, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //填充业务
            return iProductService.searchProduct(productName,productId,pageNum,pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse upload(@RequestParam(value = "upload_file",required = false) MultipartFile upload_file, HttpServletRequest request,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //与WEB-INF同级
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(upload_file,path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
            Map fileMap = Maps.newHashMap();
            fileMap.put("uri",targetFileName);
            fileMap.put("url",url);
            return ServerResponse.createBySuccess(fileMap);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping(value = "richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        Map resultMap = Maps.newHashMap();
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            resultMap.put("success",false);
            resultMap.put("msg","请登录管理员");
            return resultMap;
        }
        //校验一下是否管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //与WEB-INF同级
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            if (StringUtils.isBlank(targetFileName)){
                resultMap.put("success",false);
                resultMap.put("msg","上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
            resultMap.put("success",true);
            resultMap.put("msg","上传成功");
            resultMap.put("file_path",url);
            response.addHeader("Access-Control-Allow-Headers","X-File-Name");
            return resultMap;
        }else {
            resultMap.put("success",false);
            resultMap.put("msg","无权限操作");
            return resultMap;
        }
    }

}
