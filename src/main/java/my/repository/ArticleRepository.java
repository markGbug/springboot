package my.repository;

import my.dataobject.ArticleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface ArticleRepository extends JpaRepository<ArticleDO, Long>, JpaSpecificationExecutor<ArticleDO> {
}
