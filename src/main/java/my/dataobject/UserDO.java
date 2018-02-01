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
 * @date 2018/1/18
 */
@Entity
@Table(name = "t_user")
public class UserDO {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户昵称
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(40) COMMENT '用户昵称'")
    private String userName;

    /**
     * 登录ID
     */
    @Column(nullable = false,unique = true,columnDefinition = "VARCHAR(40) COMMENT '登录ID'")
    @NotBlank(message = "登录名不能为空")
    private String loginId;

    /**
     * 密码
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(40) COMMENT '密码'")
    @NotBlank(message = "密码不能为空")
    private String password;


    /**
     * 手机号
     */
    @Column(columnDefinition = "VARCHAR(40) COMMENT '手机号'")
    private String mobile;

    /**
     * 身份证
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(100) COMMENT '身份证'")
    private String idCard;

    /**
     * QQ
     */
    @Column(columnDefinition = "VARCHAR(40) COMMENT 'QQ'")
    private String qq;

    /**
     * 邮箱
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '邮箱'")
    private String email;

    /**
     * 用户等级
     */
    @Column(columnDefinition = "VARCHAR(10) COMMENT '用户等级'")
    private String userLevel;

    /**
     * 创建时间
     */
    @Column(updatable = false,columnDefinition = "DATETIME COMMENT '创建时间'")
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
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
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
