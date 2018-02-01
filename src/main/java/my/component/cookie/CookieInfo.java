package my.component.cookie;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/28
 */
@Component
@PropertySource(value = "classpath:/config/cookies.properties",ignoreResourceNotFound = true)
public class CookieInfo {
    public static String loginId;

    public static String name;

    public static String level;
}
