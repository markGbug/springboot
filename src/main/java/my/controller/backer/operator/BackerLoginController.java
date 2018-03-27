package my.controller.backer.operator;

import my.common.BaseJson;
import my.component.cookie.CookieInfo;
import my.controller.backer.operator.param.LoginParam;
import my.controller.backer.operator.param.OperatorParam;
import my.dataobject.OperatorDO;
import my.exception.NullableException;
import my.service.cookies.CookieManager;
import my.service.operator.OperatorService;
import my.utils.security.SDCUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Resource
    private CookieInfo cookieInfo;

    @Autowired
    private CookieManager cookieManager;

    /************************* JSON请求 ************************************/

    @PostMapping("/list")
    @ResponseBody
    public Object list(OperatorParam param){
        return operatorService.list(param);
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@Valid LoginParam param, BindingResult result) throws NullableException {
        BaseJson<OperatorDO> baseJson =  operatorService.backerLogin(param.getLoginId(), param.getPassword());
        if (!baseJson.ifSuccess()) {
            return baseJson;
        }
        //写入Cookies
        OperatorDO operatorDO = baseJson.getData();
        cookieManager.write(cookieInfo.getName(), SDCUtils.encrypt(operatorDO.getOperator(),this.getClass()));
        cookieManager.write(cookieInfo.getLoginId(),SDCUtils.encrypt(operatorDO.getLoginId(),this.getClass()));
        cookieManager.write(cookieInfo.getLevel(),SDCUtils.encrypt(String.valueOf(operatorDO.getLevel()),this.getClass()));
        return baseJson;
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(@Valid OperatorDO operatorDO,BindingResult result){
        return  operatorService.saveOrUpdate(operatorDO);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable("id") Long id){
        return  operatorService.detail(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable("id") Long id){
        return  operatorService.deleteById(id);
    }



    /************************* 页面渲染 ************************************/

    @GetMapping("/tol")
    public String index(){
        return "/backer/login";
    }

    @GetMapping("/main")
    public String main(){
        return "/backer/main";
    }

    @GetMapping("/logout")
    public Object logout() throws IllegalAccessException, NullableException {
        cookieManager.clear();
        return "/backer/login";
    }


}
