package webshop.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import webshop.model.Admin;
import webshop.model.Category;
import webshop.service.AdminService;
import webshop.service.CategoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private AdminService adminService;
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/addAdmin")
    public String addAdmin(){
        log.info("addAdmin");
        Admin admin = new Admin();
        admin.setAdminName("wt");
        adminService.addAdmin(admin);

        return "success";
    }

    @RequestMapping("/login")
    public String adminLogin(HttpSession session,Admin admin, BindingResult bindingResult, Map<String,Object> map){
        log.info("adminLogin");
        Admin dbadmin = adminService.getByName(admin.getAdminName());
        if (dbadmin==null){
            String usernameerror = "用户名不存在";
            map.put("usernameerror",usernameerror);
            return "adminLogin";
        }
        if (!dbadmin.getAdminPwd().equals(admin.getAdminPwd())){
            String passworderror = "密码错误";
            map.put("passworderror",passworderror);
            return "adminLogin";
        }
        session.setAttribute("adminid",dbadmin.getId());
        map.put("adminid",dbadmin.getId());
        map.put("shopname",dbadmin.getShopName());
        map.put("adminname",dbadmin.getAdminName());
        return "main/aindex";
    }

    @RequestMapping("/regist")
    public String adminRegist(Admin admin,BindingResult bindingResult,Map<String,Object> map){
        log.info("adminRegist");
        if (adminService.getByName(admin.getAdminName())!=null){
            String usernameerror = "此用户名已使用";
            map.put("userNameError",usernameerror);
            return "adminRegist";
        }
        if (adminService.getByShopName(admin.getShopName())!=null) {
            String shopNameError = "此店名已被使用";
            map.put("shopNameError",shopNameError);
            return "adminRegist";
        }
        admin.setCreateTime(new Date());
        admin.setModifyTime(new Date());
        adminService.addAdmin(admin);
        return "adminLogin";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        log.info("toAdminLogin");
        return "adminLogin";
    }

    @RequestMapping("/toRegist")
    public String toRegist(){
        log.info("toAdminRegist");
        return "adminRegist";
    }

    @RequestMapping("/queryCategory")
    public String queryCategory(HttpSession session,Map<String,Object> map){
        log.info("queryCategory");
        map.put("adminid",session.getAttribute("adminid"));
        return "category/query";
    }

    @ResponseBody
    @RequestMapping("/queryCategoryById")
    public Map<String, Object> queryCategoryById(@RequestParam(value = "adminid") Long adminid,@RequestParam(value = "page") Integer page,@RequestParam(value = "rows") Integer rows,@RequestParam(value = "name",required = false) String name){
        //categoryService.queryCategoryByAdminId(adminid);
        log.info("queryCategoryById");
        List<Category> categoryList = categoryService.getByAdminIdOnPage(adminid,page,rows,name);
        Long total = categoryService.getCountByAdminId(adminid);
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("rows",categoryList);
        pageMap.put("total",total);
        return pageMap;
    }

    @ModelAttribute
    public void getAdmin(@RequestParam(value = "id",required = false) Long id,Map<String, Object> map){
        if (id != null){
            System.out.println(id);
            map.put("admin",adminService.getAdminById(id));
        }else {
            Admin admin = new Admin();
            map.put("admin",admin);
        }
    }

}
