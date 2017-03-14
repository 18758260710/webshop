package webshop.service;

import webshop.model.Admin;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface AdminService {
    void addAdmin(Admin admin);
    Admin getAdminById(Long id);
    Admin getByName(String name);
    Admin getByShopName(String name);
}
