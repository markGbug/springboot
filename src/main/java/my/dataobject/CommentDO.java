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
 * @date 2018/1/25
 */
@Entity
@Table(name = "t_comment")
public class CommentDO {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 业务ID
     */
    @Column(nullable = false, columnDefinition = "BIGINT(20) COMMENT '业务ID'")
    private Long bizId;

    /**
     * IP地址
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '业务ID'")
    private String ipAddress;

    /**
     * 用户昵称
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(40) COMMENT '用户昵称'")
    private String nickName;

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

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        return "CommentDO{" +
                "id=" + id +
                ", bizId=" + bizId +
                ", ipAddress='" + ipAddress + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
