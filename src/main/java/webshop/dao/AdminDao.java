package webshop.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import webshop.model.Admin;

/**
 * Created by Administrator on 2017/3/12.
 */
@Repository
public interface AdminDao {
    void addAdmin(Admin admin);
    Admin getById(@Param("adminId") Long id);
    Admin getByName(@Param("adminName") String name);
    Admin getByShopName(@Param("shopName") String name);
}
