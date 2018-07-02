package my.controller.backer.article;

import my.common.BaseJson;
import my.controller.backer.article.param.ArticleParam;
import my.dataobject.ArticleDO;
import my.service.article.ArticleService;
import my.utils.security.MD5Utils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/10
 */
@Controller
@RequestMapping("/backer/article")
public class BackerArticleController {

    @Resource
    private ArticleService articleService;

    /************************* JSON请求 ************************************/


    /************************* 页面渲染 ************************************/
    @GetMapping("/list")
    public String list(ArticleParam param, Model model) {
        BaseJson<Page<ArticleDO>> baseJson = articleService.list(param);
        model.addAttribute("data", baseJson.getData().getContent());
        model.addAttribute("total", baseJson.getData().getTotalElements());
        model.addAttribute("pageNo", baseJson.getData().getTotalPages());
        model.addAttribute("pageSize", baseJson.getData().getSize());
        return "/backer/article/list";
    }


    public static void main(String[] args) {
        System.out.println(MD5Utils.encrypt("zhangbj"));
    }
}
