package my.service.operator;

import my.common.BaseJson;
import my.controller.backer.operator.param.OperatorParam;
import my.dataobject.OperatorDO;
import org.springframework.data.domain.Page;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/29
 */
public interface OperatorService {

    /**
     * 登录校验
     * @param loginId
     * @param password
     */
    BaseJson<OperatorDO> backerLogin(String loginId, String password);

    /**
     * 管理员列表
     * @param param
     * @return
     */
    BaseJson<Page<OperatorDO>> list(OperatorParam param);
}
