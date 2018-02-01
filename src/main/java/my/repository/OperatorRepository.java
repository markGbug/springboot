package my.repository;

import my.dataobject.OperatorDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public interface OperatorRepository extends JpaRepository<OperatorDO,Long> {

    /**
     * 登录
     * @param LoginId
     * @param password
     * @return
     */
    OperatorDO findByLoginIdAndPassword(String LoginId,String password);

    /**
     * 查询用户列表
     * @param operator
     * @param pageable
     * @return
     */
    Page<OperatorDO> findByOperatorLike(String operator, Pageable pageable);


}
