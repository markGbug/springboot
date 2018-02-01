package my.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/22
 */
@Controller
@RequestMapping("/blog")
public class BlogIndexController {

    /**
     * 跳转个人博客主页
     *
     * @return
     */
    @RequestMapping("")
    public String index() {
        return "/blog/home";
    }

    /**
     * 跳转关于本站页面
     *
     * @return
     */
    @RequestMapping("/about")
    public String blogAbout() {
        return "/blog/about";
    }

    @RequestMapping("/resource")
    public String resource() {
        return "/blog/resource";
    }

    @RequestMapping("/article")
    public String article() {
        return "/blog/article";
    }


    @RequestMapping("/timeline")
    public String timeline() {
        return "/blog/timeline";
    }
}
