package my.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangbj
 * @version 1.0
 * @Type BasicController
 * @Desc
 * @data 2017/11/16
 */
//@RestController controller类里面的方法输出形式都默认为json格式
@Controller
public class BasicController {

    @RequestMapping("/")
    public String basic(){
        return "/index";
    }


}
