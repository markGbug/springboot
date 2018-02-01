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
@Table(name = "t_article_type")
public class ArticleTypeDO {

    @Id
    @GeneratedValue
    private Integer typeId;

    /**
     * 类型名称
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(40) COMMENT '类型名称'")
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "ArticleTypeDO{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
