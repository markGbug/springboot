package my.repository;

import my.dataobject.CommentDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface CommentRepository extends JpaRepository<CommentDO, Long> {
}
