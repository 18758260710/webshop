package webshop.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
public class Admin {
    private Long id;
    @NotEmpty
    private String adminName;
    private String adminPhone;
    @Email
    private String adminEmail;
    private String adminPwd;
    private String pwdSalt;
    private String shopName;
    private boolean isDelete;
    private Date createTime;
    private Date modifyTime;
    private List<Category> categoryList;

    public Admin() {
    }

    public Admin(Long id, String adminName, String adminPhone, String adminEmail, String adminPwd, String pwdSalt, String shopName, boolean isDelete, Date createTime, Date modifyTime) {
        this.id = id;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminEmail = adminEmail;
        this.adminPwd = adminPwd;
        this.pwdSalt = pwdSalt;
        this.shopName = shopName;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", pwdSalt='" + pwdSalt + '\'' +
                ", shopName='" + shopName + '\'' +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
