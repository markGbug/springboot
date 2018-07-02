package my.service.operator.impl;

import my.common.BaseConstants;
import my.common.BaseJson;
import my.component.init.InitComponent;
import my.controller.backer.operator.param.OperatorParam;
import my.dataobject.OperatorDO;
import my.repository.OperatorRepository;
import my.service.operator.OperatorService;
import my.utils.security.MD5Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/29
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    @Resource
    private OperatorRepository operatorRepository;

    @Resource
    private InitComponent initComponent;

    @Override
    public BaseJson<OperatorDO> backerLogin(String loginId, String password) {
        BaseJson<OperatorDO> baseJson = new BaseJson<>();
        OperatorDO operatorDO = operatorRepository.findByLoginIdAndPassword(loginId, MD5Utils.encrypt(password));
        if (operatorDO == null) {
            baseJson.setResult(BaseConstants.RespCode.ERROR, "用户名或密码错误");
            return baseJson;
        }
        baseJson.setSuccessResult("登录成功", operatorDO);
        return baseJson;
    }

    @Override
    public BaseJson<Page<OperatorDO>> list(OperatorParam param) {
        BaseJson<Page<OperatorDO>> baseJson = new BaseJson<>();
        Page<OperatorDO> page = operatorRepository.findByOperatorLike(param.getOperator(), new PageRequest(param.getPageNo(), param.getPageSize()));
        baseJson.setSuccessResult("查询成功", page);
        return baseJson;
    }

    @Override
    public List<OperatorDO> findAll() {
        return operatorRepository.findAll();
    }

    @Override
    public BaseJson<OperatorDO> saveOrUpdate(OperatorDO operatorDO) {
        BaseJson<OperatorDO> baseJson = new BaseJson<>();
        OperatorDO result = operatorRepository.save(operatorDO);
        if (null == result) {
            baseJson.setFailResult(BaseConstants.RespCode.ERROR, "操作失败");
            return baseJson;
        }
        baseJson.setSuccessResult("操作成功", result);
        initComponent.operatorFlush();
        return baseJson;
    }

    @Override
    public BaseJson deleteById(Long id) {
        BaseJson baseJson = new BaseJson();
        operatorRepository.delete(id);
        initComponent.operatorFlush();
        baseJson.setSuccessResult("删除成功", null);
        return baseJson;
    }

    @Override
    public BaseJson<OperatorDO> detail(Long id) {
        BaseJson<OperatorDO> baseJson = new BaseJson<>();
        OperatorDO operatorDO = operatorRepository.findOne(id);
        if (null == operatorDO) {
            baseJson.setFailResult(BaseConstants.RespCode.ERROR, "查询失败");
            return baseJson;
        }
        baseJson.setSuccessResult("查询成功", operatorDO);
        return baseJson;
    }
}
