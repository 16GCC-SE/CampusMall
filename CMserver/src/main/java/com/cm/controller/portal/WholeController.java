package com.cm.controller.portal;

import com.cm.service.IWholeService;
import com.cm.util.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaochaofan
 * @date 2018/12/12 20:17
 */
@Controller
public class WholeController {

    @Autowired
    private IWholeService iWholeService;

    @RequestMapping(value = "/home" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHomeDatas(HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        String a = iWholeService.getHomeDatas();
        return a;
    }

    @RequestMapping(value = "/category" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCategory( HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");

        return iWholeService.getCategory();
    }

    @RequestMapping(value = "/categorygoods" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCategoryGoods(@Param("mId")Integer mId, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");

        return iWholeService.getCategoryGoods(mId);
    }

    @RequestMapping(value = "/userinfo" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getUserInfo(@Param("uId")Integer uId, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return iWholeService.getUserInfo(uId);
    }


    @RequestMapping(value = "/login" ,method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest request,@RequestBody String info, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        try {
            byte[] b=info.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
            String str= URLDecoder.decode(info,"utf-8").replace("=","");
            Map user = JsonUtil.string2Obj(str,Map.class);
            return iWholeService.login((String) user.get("loginName"),(String)user.get("loginPawd"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/cart" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCart(@Param("uId")Integer uId, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return iWholeService.getCart(uId);
    }

    @RequestMapping(value = "/detail" , produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getProductDetil(@Param("mId")Integer mId, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return iWholeService.getProductDetail(mId);
    }


    @RequestMapping(value = "/reg" ,method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String register(HttpServletRequest request,@RequestBody String info, HttpServletResponse response){
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        try {
            byte[] b=info.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
            String str= URLDecoder.decode(info,"utf-8").replace("=","");
            Map user = JsonUtil.string2Obj(str,Map.class);
            return iWholeService.register((String) user.get("regName"),(String)user.get("regPasswd"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }







}
