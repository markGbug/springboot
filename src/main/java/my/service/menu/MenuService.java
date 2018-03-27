package my.service.menu;

import my.common.BaseJson;
import my.controller.backer.menu.param.MenuParam;
import my.dataobject.MenuDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/7
 */
public interface MenuService {
    /**
     * 查询菜单列表
     * @param param
     * @return
     */
    public BaseJson<Page<MenuDO>> list(MenuParam param);

    /**
     * 新增修改菜单
     * @param menuDO
     * @return
     */
    public BaseJson<MenuDO> saveOrUpdate(MenuDO menuDO);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    public BaseJson delete(Long id);

    /**
     * 菜单详情
     * @param id
     * @return
     */
    public BaseJson<MenuDO> detail(Long id);

    /**
     * 获取所有菜单数据（不直接对外提供）
     * @return
     */
    List<MenuDO> findAll();

}
