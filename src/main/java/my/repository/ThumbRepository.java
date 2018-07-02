package my.repository;

import my.dataobject.ThumbDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface ThumbRepository extends JpaRepository<ThumbDO, Long> {
}
