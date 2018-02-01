package my.dataobject;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/19
 */
@Entity
@Table(name = "t_operator")
public class OperatorDO {


    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 操作员
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '操作员'")
    private String operator;

    /**
     * 登录ID
     */
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(40) COMMENT '登录ID'")
    @NotBlank(message = "登录名不能为空")
    private String loginId;

    /**
     * 密码
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '密码'")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 手机号
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '手机号'")
    private String mobile;

    /**
     * 身份证
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '身份证'")
    private String idCard;

    /**
     * QQ
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT 'QQ'")
    private String qq;

    /**
     * 邮箱
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '邮箱'")
    private String email;

    /**
     * 权限级别
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '权限级别'")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "OperatorDO{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
