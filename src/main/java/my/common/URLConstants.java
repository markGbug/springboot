package my.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/19
 */
public class URLConstants {
    /**
     * 需要登录验证
     */
    private static final List<String> LoginVerifyList = new ArrayList<>();
    /**
     * 忽略所有验证
     */
    private static final List<String> IgnoreUrlList = new ArrayList<>();

    public static List<String> getLoginVerifyList() {
        return LoginVerifyList;
    }

    public static List<String> getIgnoreUrlList() {
        return IgnoreUrlList;
    }

    /**
     * 静态块，装载校验URL
     */
    static {
        LoginVerifyList.add("/backer");
        IgnoreUrlList.add("/blog");
        IgnoreUrlList.add("/backer/tol");
        IgnoreUrlList.add("/backer/login");
    }
}
