package my.repository;

import my.dataobject.ReadCountDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface ReadCountRepository extends JpaRepository<ReadCountDO, Long> {
}
