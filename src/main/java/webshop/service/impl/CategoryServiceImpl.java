package webshop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webshop.dao.CategoryDao;
import webshop.model.Category;
import webshop.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public List<Category> queryCategoryByAdminId(Long adminid) {
        return categoryDao.getByAdminId(adminid);
    }

    public Long getCountByAdminId(Long adminid) {
        return categoryDao.getCountByAdminId(adminid);
    }

    public List<Category> getByAdminIdOnPage(Long adminid, Integer page, Integer rows, String name) {
        Integer begin = (page-1)*rows;
        Integer end = rows;
        if (name == null){
            name = "%%";
        }else {
            name = "%" + name + "%";
        }
        return categoryDao.getByAdminIdOnPage(adminid,begin,end,name);
    }
}
