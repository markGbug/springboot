package my.dataobject;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/7
 */
@Entity
@Table(name = "t_menu")
@EntityListeners(AuditingEntityListener.class)
public class MenuDO {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 菜单名称
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '菜单名称'")
    private String menuName;

    /**
     * 父节点ID
     */
    @Column(columnDefinition = "VARCHAR(40) COMMENT '父节点ID'")
    private Long parentId;

    /**
     * 菜单链接
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '菜单链接'")
    private String menuUrl;

    /**
     * 操作员
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '操作员'")
    private String operator;

    /**
     * 等级
     */
    @Column(nullable = false, columnDefinition = "TINYINT(2) COMMENT '等级'")
    private Integer level;

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

    @Transient
    private List<MenuDO> menuDOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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


    public List<MenuDO> getMenuDOList() {
        return menuDOList;
    }

    public void setMenuDOList(List<MenuDO> menuDOList) {
        this.menuDOList = menuDOList;
    }
}
