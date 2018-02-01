package my.controller;

import my.common.BaseConstants;
import my.common.BaseJson;
import my.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import my.repository.UserRepository;
import my.utils.security.MD5Utils;

import javax.validation.Valid;


/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/front/login",method = RequestMethod.POST)
    public Object login(String loginId,String password){
        UserDO userDO = userRepository.findByLoginIdAndPassword(loginId, MD5Utils.encrypt(password));
        return "";
    }

    @RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
    public Object saveOrUpdate(@Valid UserDO userDO, BindingResult result){
        BaseJson<UserDO> baseJson = new BaseJson<>();
        UserDO res = userRepository.saveAndFlush(userDO);
        if (null == res){
            baseJson.setResult(BaseConstants.RespCode.EXCEPTION,"操作失败",userDO);
            return baseJson;
        }
        baseJson.setResult(BaseConstants.RespCode.SUCCESS,"操作成功",userDO);
        return baseJson;
    }

    @RequestMapping(value = "/back/delete",method = RequestMethod.POST)
    public Object delete(Long id){
        BaseJson<UserDO> baseJson = new BaseJson<>();
        Boolean result = userRepository.deleteById(id);
        if (false == result){
            baseJson.setResult(BaseConstants.RespCode.EXCEPTION,"操作失败");
            return baseJson;
        }
        baseJson.setResult(BaseConstants.RespCode.SUCCESS,"操作成功");
        return baseJson;
    }
}
