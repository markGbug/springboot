package my.dataobject;

import javax.persistence.*;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
@Entity
@Table(name = "t_thumb")
public class ThumbDO {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 业务ID
     */
    @Column(nullable = false, columnDefinition = "BIGINT(20) COMMENT '业务ID'")
    private Long bizId;

    /**
     * 点赞量
     */
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '点赞量'")
    private Long thumbCount;

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

    public Long getThumbCount() {
        return thumbCount;
    }

    public void setThumbCount(Long thumbCount) {
        this.thumbCount = thumbCount;
    }

    @Override
    public String toString() {
        return "ThumbDO{" +
                "id=" + id +
                ", bizId=" + bizId +
                ", thumbCount=" + thumbCount +
                '}';
    }
}
