package my.controller.backer.operator;

import my.common.BaseJson;
import my.component.cookie.CookieInfo;
import my.component.cookie.LoginCookies;
import my.controller.backer.operator.param.LoginParam;
import my.controller.backer.operator.param.OperatorParam;
import my.dataobject.OperatorDO;
import my.exception.NullableException;
import my.service.operator.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/backer")
public class BackerLoginController {

    @Resource
    private OperatorService operatorService;

    /************************* JSON请求 ************************************/

    @PostMapping("/list")
    @ResponseBody
    public Object list(OperatorParam param){
        return operatorService.list(param);
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody @Valid LoginParam param, BindingResult result) throws NullableException {
        BaseJson<OperatorDO> baseJson =  operatorService.backerLogin(param.getLoginId(), param.getPassword());
        if (!baseJson.ifSuccess()) {
            return baseJson;
        }
        //写入Cookies
        OperatorDO operatorDO = new OperatorDO();
        LoginCookies cookies = new LoginCookies();
        cookies.write(CookieInfo.name,operatorDO.getOperator());
        cookies.write(CookieInfo.loginId,operatorDO.getLoginId());
        cookies.write(CookieInfo.level,String.valueOf(operatorDO.getLevel()));
        return baseJson;
    }
    /************************* 跳转页面 ************************************/

    @GetMapping("/tol")
    public String index(){
        return "/backer/login";
    }

    @GetMapping("/main")
    public String main(){
        return "/backer/main";
    }

}
