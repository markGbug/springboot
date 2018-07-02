package my.component.init;

import my.dataobject.MenuDO;
import my.dataobject.OperatorDO;
import my.service.menu.MenuService;
import my.service.operator.OperatorService;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/7
 */
@Component
public class InitComponent {

    @Resource
    private MenuService menuService;

    @Resource
    private OperatorService operatorService;
    /**
     * 嵌套菜单数据
     */
    public static final List<MenuDO> NEST_MENU_LIST = new ArrayList<>();

    /**
     * 操作人员数据
     */
    public static final Map<String, OperatorDO> OPERATOR_MAP = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(InitComponent.class);

    @PostConstruct
    public void init() {
        menuInit();
        operatorInit();
    }

    /**
     * 初始化菜单列表
     */
    private void menuInit() {
        List<MenuDO> list = menuService.findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        NEST_MENU_LIST.addAll(list.stream()
                .filter(menuDO -> menuDO.getParentId() == null)
                .collect(Collectors.toList()));
        NEST_MENU_LIST.forEach(menuDO -> {
            List<MenuDO> menuDOS = list.stream().filter(menu ->
                    !ObjectUtils.notEqual(menuDO.getId(), menu.getParentId()))
                    .collect(Collectors.toList());
            menuDO.setMenuDOList(menuDOS);
        });
    }

    /**
     * 初始化操作人员列表
     */
    private void operatorInit() {
        List<OperatorDO> list = operatorService.findAll();
        list.forEach(operatorDO -> OPERATOR_MAP.put(operatorDO.getLoginId(), operatorDO));
    }

    /**
     * 刷新菜单列表
     */
    public void menuFlush() {
        NEST_MENU_LIST.clear();
        this.menuInit();
    }

    /**
     * 刷新操作员数据
     */
    public void operatorFlush() {
        OPERATOR_MAP.clear();
        this.operatorInit();
    }
}
