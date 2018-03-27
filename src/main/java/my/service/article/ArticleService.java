package my.service.article;

import my.common.BaseJson;
import my.controller.backer.article.param.ArticleParam;
import my.dataobject.ArticleDO;
import org.springframework.data.domain.Page;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/10
 */
public interface ArticleService {

    /**
     * 查询列表
     * @param param
     * @return
     */
    public BaseJson<Page<ArticleDO>> list(ArticleParam param);

    /**
     * 新增修改文章
     * @param articleDO
     * @return
     */
    public BaseJson<ArticleDO> saveOrUpdate(ArticleDO articleDO);

    /**
     * 删除文章
     * @param id
     * @return
     */
    public BaseJson delete(Long id);

    /**
     * 文章详情
     * @param id
     * @return
     */
    public BaseJson<ArticleDO> detail(Long id);

    /**
     * 统计文章数据
     * @return
     */
    public BaseJson<Integer> count();
}
