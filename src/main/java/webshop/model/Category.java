package webshop.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Category {
    private Long id;
    private String categoryName;
    private boolean hot;
    private Date createTime;
    private Date modifyTime;
    private Long adminId;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", hot=" + hot +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", adminId=" + adminId +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
