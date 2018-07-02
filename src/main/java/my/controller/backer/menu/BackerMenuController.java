package my.controller.backer.menu;

import my.common.BaseJson;
import my.controller.backer.menu.param.MenuParam;
import my.dataobject.MenuDO;
import my.service.menu.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/6
 */
@Controller
@RequestMapping("/backer/menu")
public class BackerMenuController {

    @Resource
    private MenuService menuService;

    /************************* JSON请求 ************************************/

    @PostMapping("/list")
    @ResponseBody
    public Object list(MenuParam menuParam) {
        return menuService.list(menuParam);
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(MenuDO menuDO) {
        return menuService.saveOrUpdate(menuDO);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable("id") Long id) {
        return menuService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable("id") Long id) {
        return menuService.detail(id);
    }

    /************************* 页面渲染 ************************************/

    @GetMapping("")
    public String list(MenuParam menuParam, Model model) {
        BaseJson<Page<MenuDO>> baseJson = menuService.list(menuParam);
        model.addAttribute("param", menuParam);
        model.addAttribute("data", baseJson.getData().getContent());
        model.addAttribute("total", baseJson.getData().getTotalElements());
        model.addAttribute("pageNo", baseJson.getData().getTotalPages());
        model.addAttribute("pageSize", baseJson.getData().getSize());
        return "/backer/menu/list";
    }
}
