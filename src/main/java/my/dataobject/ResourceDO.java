package my.dataobject;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
@Entity
@Table(name = "t_resource")
public class ResourceDO {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 资源名称
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '资源名称'")
    private String resourceName;

    /**
     * 资源简介
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(200) COMMENT '资源简介'")
    private String resourceDesc;

    /**
     * 上传作者
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '上传作者'")
    private String resourceOwner;

    /**
     * 资源类别
     */
    @Column(nullable = false, columnDefinition = "TINYINT(2) COMMENT '资源类别'")
    private Integer resourceType;

    /**
     * 创建时间
     */
    @Column(updatable = false, columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreated;

    /**
     * 修改时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(String resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ResourceDO{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceDesc='" + resourceDesc + '\'' +
                ", resourceOwner='" + resourceOwner + '\'' +
                ", resourceType=" + resourceType +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
