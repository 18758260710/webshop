package webshop.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import webshop.model.User;

import java.util.List;


/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {


    User selectUserById(@Param("userId") Long userId);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<User> selectAllUser();
}
