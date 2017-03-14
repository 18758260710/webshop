package webshop.service;

import webshop.model.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface CategoryService {
    List<Category> queryCategoryByAdminId(Long adminid);
    Long getCountByAdminId(Long adminid);
    List<Category> getByAdminIdOnPage(Long adminid,Integer page,Integer rows,String name);
}
