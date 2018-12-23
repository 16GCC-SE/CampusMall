package com.cm.service.impl;

import com.cm.dao.CartMapper;
import com.cm.dao.CategoryMapper;
import com.cm.dao.ProductMapper;
import com.cm.dao.UserMapper;
import com.cm.pojo.Cart;
import com.cm.pojo.Category;
import com.cm.pojo.Product;
import com.cm.pojo.User;
import com.cm.service.IWholeService;
import com.cm.util.BigDecimalUtil;
import com.cm.util.JsonUtil;
import com.cm.util.PropertiesUtil;
import com.cm.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaochaofan
 * @date 2018/12/12 20:19
 */
@Service("iWholeService")
public class WholeServiceImpl implements IWholeService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    public String getHomeDatas(){
        List<JHomeVo> jHomeVoList = assembleJHomeVoList(productMapper.selectList());
        return JsonUtil.obj2String(jHomeVoList);
    }

    public String getCategory(){
        List<JCategoryVo> jCategoryVoList = assembleJCategoryVo();
        return JsonUtil.obj2String(jCategoryVoList);
    }

    public String getCategoryGoods(Integer mId){
        List<JCategoryGoodVo> jCategoryGoodVoList = assembleJCategoryGoods(mId);
        return JsonUtil.obj2String(jCategoryGoodVoList);
    }

    public String login(String username, String password) {
        User user = userMapper.selectLogin(username,password);
        JUserVo jUserVo = null;
        if(user != null){
            jUserVo = new JUserVo();
            jUserVo.setPay_password(user.getPassword());
            jUserVo.setStatus(1);
            jUserVo.setUser_name(username);
            jUserVo.setUser_number(user.getPhone());
            jUserVo.setUser_id(user.getId());
        }
        return JsonUtil.obj2String(jUserVo);
    }

    public String register(String username, String password) {
        User user = new User();
        JUserVo jUserVo = new JUserVo();
        int resultCount = userMapper.checkUsername(username);
        if(resultCount > 0 ){
            jUserVo.setStatus(0);
            return JsonUtil.obj2String(jUserVo);
        }else {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail("1305@qq.com");
            user.setQuestion("a");
            user.setAnswer("a");
            user.setPhone("12345678910");
            user.setRole(0);
            resultCount = userMapper.insert(user);
            if (resultCount > 0){
                jUserVo.setStatus(1);
                return JsonUtil.obj2String(jUserVo);
            }else {
                jUserVo.setStatus(0);
                return JsonUtil.obj2String(jUserVo);
            }
        }
    }



    public String getUserInfo(Integer uId){
        User user = userMapper.selectByPrimaryKey(uId);

        if (user != null){
            JUserVo jUserVo = new JUserVo();
            jUserVo.setUser_number(user.getPhone());
            jUserVo.setUser_name(user.getUsername());
            return JsonUtil.obj2String(jUserVo);
        }
        return "";
    }

    public String getCart(Integer uId){
        List<Cart> cartList = cartMapper.selectCartByUserId(uId);
        List<JCartVo> jCartVoList = new ArrayList<>();
        for (Cart cart : cartList){
            JCartVo jCartVo = new JCartVo();
            jCartVo.setProduct_id(cart.getId());
            jCartVo.setCart_id(cart.getId());
            jCartVo.setGoods_num(cart.getQuantity());
            jCartVo.setUser_id(cart.getUserId());
            Product product = productMapper.selectByPrimaryKey(cart.getProductId());
            jCartVo.setProduct_img_url(product.getMainImage());
            jCartVo.setProduct_name(product.getName());
            jCartVo.setShop_name("广商校园");
            jCartVo.setProduct_uprice(product.getPrice());
            jCartVoList.add(jCartVo);
        }
        return JsonUtil.obj2String(jCartVoList);
    }


    public String getProductDetail(Integer mId){
        Product product = productMapper.selectByPrimaryKey(mId);
        List<JImgUrlVo> imgList = new ArrayList<>();
        imgList.add(new JImgUrlVo(product.getMainImage()));
        imgList.add(new JImgUrlVo(product.getSubImage()));
        JProductVo jProductVo = new JProductVo();
        jProductVo.setProduct_detail(product.getDetail());
        jProductVo.setProduct_id(product.getId());
        jProductVo.setProduct_name(product.getName());
        jProductVo.setProduct_price(product.getPrice());
        List<Object> productDetail = new ArrayList<>();

        List<JProductVo> jProductVoList = new ArrayList<>();
        jProductVoList.add(jProductVo);
        productDetail.add(imgList);
        productDetail.add(jProductVoList);
        return JsonUtil.obj2String(productDetail);
    }

    private List<JCategoryGoodVo> assembleJCategoryGoods(Integer mId){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(mId);
        integerList.add(1);
        List<Product> productList = productMapper.selectByNameAndCategoryIds(null,integerList);
        List<JCategoryGoodVo> jCategoryGoodVoList = new ArrayList<>();
        for (Product product : productList){
            JCategoryGoodVo jCategoryGoodVo = new JCategoryGoodVo();
            jCategoryGoodVo.setProduct_id(product.getId());
            jCategoryGoodVo.setProduct_img_url(PropertiesUtil.getProperty("ftp.server.http.prefix","http://192.168.88.157/img/") + product.getMainImage());
            jCategoryGoodVo.setProduct_name(product.getName());
            jCategoryGoodVoList.add(jCategoryGoodVo);
        }
        return jCategoryGoodVoList;
    }

    private List<JCategoryVo> assembleJCategoryVo(){
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(0);
        List<JCategoryVo> jCategoryVoList = new ArrayList<>();
        for (Category category : categoryList){
            List<Category> childNotes = categoryMapper.selectCategoryChildrenByParentId(category.getId());
            for (Category item : childNotes){
                JCategoryVo jCategoryVo = new JCategoryVo();
                jCategoryVo.setCategory_id(item.getId());
                jCategoryVo.setCategory_name(item.getName());
                jCategoryVoList.add(jCategoryVo);
            }
        }
        return jCategoryVoList;
    }


    private List<JHomeVo> assembleJHomeVoList(List<Product> productList){
        List<JHomeVo> jHomeVoList = new ArrayList<>();
        for (Product item : productList){
            jHomeVoList.add(assembleJHomeVo(item));
        }
        return jHomeVoList;
    }
    private JHomeVo assembleJHomeVo(Product product){
        JHomeVo jHomeVo = new JHomeVo();
        jHomeVo.setProduct_id(product.getId());
        jHomeVo.setProduct_img_url(PropertiesUtil.getProperty("ftp.server.http.prefix") + product.getMainImage());
        jHomeVo.setProduct_name(product.getName());
        jHomeVo.setProduct_price(product.getPrice());
        jHomeVo.setProduct_uprice(BigDecimalUtil.add(product.getPrice().doubleValue(), 50));
        return jHomeVo;
    }
}
