package webshop.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import webshop.model.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Repository
public interface CategoryDao {
    List<Category> getByAdminId(@Param("adminId") Long adminId);
    List<Category> getByAdminIdOnPage(@Param("adminId") Long adminId,@Param("begin") Integer begin,@Param("end") Integer end,@Param("name") String name);
    Long getCountByAdminId(@Param("adminId") Long adminId);
}
