package my.repository;

import my.dataobject.NoticeDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface NoticeRepository extends JpaRepository<NoticeDO,Long> {
}
