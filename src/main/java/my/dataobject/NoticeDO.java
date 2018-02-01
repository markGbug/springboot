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
@Table(name = "t_notice")
public class NoticeDO {

    /**
     * 通知ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 通知内容
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(100) COMMENT '通知内容'")
    private String noticeContent;

    /**
     * 链接地址
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '链接地址'")
    private String linkedUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    @Override
    public String toString() {
        return "NoticeDO{" +
                "id=" + id +
                ", noticeContent='" + noticeContent + '\'' +
                ", linkedUrl='" + linkedUrl + '\'' +
                '}';
    }
}
