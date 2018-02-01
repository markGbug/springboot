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
@Table(name = "t_article")
public class ArticleDO {
    /**
     * 文章ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 文章类别
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(100) COMMENT '文章类别'")
    private Integer articleType;

    /**
     * 文章标题
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(100) COMMENT '文章标题'")
    private String articleTitle;

    /**
     * 文章内容
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(100) COMMENT '文章内容'")
    private String articleContent;

    /**
     * 作者
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '作者'")
    private String author;

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

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return "ArticleDO{" +
                "id=" + id +
                ", articleType=" + articleType +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", author='" + author + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
