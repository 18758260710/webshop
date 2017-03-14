package webshop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webshop.dao.AdminDao;
import webshop.model.Admin;
import webshop.service.AdminService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    public void addAdmin(Admin admin) {
        System.out.println(admin);
        adminDao.addAdmin(admin);
    }

    public Admin getAdminById(Long id) {
        return adminDao.getById(id);
    }

    public Admin getByName(String name) {
        return adminDao.getByName(name);
    }

    public Admin getByShopName(String name) {
        return adminDao.getByShopName(name);
    }
}
