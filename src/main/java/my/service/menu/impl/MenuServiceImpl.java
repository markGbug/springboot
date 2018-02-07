package my.service.menu.impl;

import my.common.BaseConstants;
import my.common.BaseJson;
import my.component.init.InitComponent;
import my.controller.backer.menu.param.MenuParam;
import my.dataobject.MenuDO;
import my.repository.MenuRepository;
import my.service.menu.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/7
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;
    @Resource
    private InitComponent initComponent;

    @Override
    public BaseJson<Page<MenuDO>> list(MenuParam param) {
        BaseJson<Page<MenuDO>> baseJson = new BaseJson<>();
        Page<MenuDO> list = menuRepository.findAll(new Specification<MenuDO>() {
            @Override
            public Predicate toPredicate(Root<MenuDO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(param.getMenuName())) {
                    list.add(cb.like(root.get("name").as(String.class), param.getMenuName() + "%"));
                }
                if (null != param.getParentId()) {
                    list.add(cb.equal(root.get("parentId").as(Long.class), param.getParentId()));
                }
                return cb.and((Predicate[]) list.toArray());
            }
        }, new PageRequest(param.getPageNo(),param.getPageSize()));
        baseJson.setSuccessResult("查询成功",list);
        return baseJson;
    }

    @Override
    public BaseJson<MenuDO> saveOrUpdate(MenuDO menuDO) {
        BaseJson<MenuDO> baseJson = new BaseJson<>();
        MenuDO result = menuRepository.save(menuDO);
        if (result == null) {
            baseJson.setFailResult(BaseConstants.RespCode.ERROR, "操作失败");
            return baseJson;
        }
        initComponent.menuFlush();
        baseJson.setSuccessResult("操作成功", result);
        return baseJson;
    }

    @Override
    public BaseJson delete(Long id) {
        BaseJson baseJson = new BaseJson();
        menuRepository.delete(id);
        baseJson.setSuccessResult("删除成功", null);
        initComponent.menuFlush();
        return baseJson;
    }

    @Override
    public BaseJson<MenuDO> detail(Long id) {
        BaseJson<MenuDO> baseJson = new BaseJson();
        MenuDO menuDO = menuRepository.findOne(id);
        if (menuDO == null) {
            baseJson.setFailResult(BaseConstants.RespCode.ERROR, "查询失败");
            return baseJson;
        }
        baseJson.setSuccessResult("查询成功", menuDO);
        return baseJson;
    }

    @Override
    public List<MenuDO> findAll() {
        return menuRepository.findAll();
    }
}
