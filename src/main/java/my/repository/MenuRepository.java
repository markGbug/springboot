package my.repository;

import my.dataobject.MenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/7
 */
public interface MenuRepository extends JpaRepository<MenuDO,Long>,JpaSpecificationExecutor<MenuDO>{
}
