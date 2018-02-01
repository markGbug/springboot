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
@Table(name = "t_read_count")
public class ReadCountDO {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 业务ID
     */
    @Column(nullable = false,unique = true,columnDefinition = "BIGINT(20) COMMENT '业务ID'")
    private Long bizId;

    /**
     * 阅读量
     */
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '阅读量'")
    private Long readCount;

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

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "ReadCountDO{" +
                "id=" + id +
                ", bizId=" + bizId +
                ", readCount=" + readCount +
                '}';
    }
}
