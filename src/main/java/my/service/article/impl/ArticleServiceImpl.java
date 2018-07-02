package my.service.article.impl;

import my.common.BaseJson;
import my.controller.backer.article.param.ArticleParam;
import my.dataobject.ArticleDO;
import my.repository.ArticleRepository;
import my.service.article.ArticleService;
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
 * @date 2018/2/10
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public BaseJson<Page<ArticleDO>> list(ArticleParam param) {
        BaseJson<Page<ArticleDO>> baseJson = new BaseJson<>();
        Page<ArticleDO> page = articleRepository.findAll(new Specification<ArticleDO>() {
            @Override
            public Predicate toPredicate(Root<ArticleDO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(param.getArticleTitle())) {
                    list.add(cb.like(root.get("articleTitle").as(String.class), param.getArticleTitle() + "%"));
                }
                if (StringUtils.isNotBlank(param.getAuthor())) {
                    list.add(cb.like(root.get("author").as(String.class), param.getAuthor() + "%"));
                }
                if (null != param.getArticleType()) {
                    list.add(cb.equal(root.get("articleType"), param.getArticleType()));
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        }, new PageRequest(param.getPageNo() - 1, param.getPageSize()));
        baseJson.setSuccessResult("查询成功", page);
        return null;
    }

    @Override
    public BaseJson<ArticleDO> saveOrUpdate(ArticleDO articleDO) {
        return null;
    }

    @Override
    public BaseJson delete(Long id) {
        return null;
    }

    @Override
    public BaseJson<ArticleDO> detail(Long id) {
        return null;
    }

    @Override
    public BaseJson<Integer> count() {

        return null;
    }
}
