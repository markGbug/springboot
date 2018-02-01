package my.repository;

import my.dataobject.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/18
 */
public interface UserRepository extends JpaRepository<UserDO, Long> {

    /**
     * 登录并获取用户信息
     * @param loginId
     * @param password
     * @return
     */
    UserDO findByLoginIdAndPassword(String loginId,String password);

    /**
     * 条件查询
     * @param userDO
     * @param pageable
     * @return
     */
    Page<UserDO> findByLoginIdAndMobileAndUserNameIsLike(UserDO userDO,Pageable pageable);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean deleteById(Long id);
}
