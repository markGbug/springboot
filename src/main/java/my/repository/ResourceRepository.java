package my.repository;

import my.dataobject.ResourceDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
public interface ResourceRepository extends JpaRepository<ResourceDO,Long> {
}
