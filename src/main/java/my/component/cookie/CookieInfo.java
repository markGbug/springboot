package my.component.cookie;

import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties(prefix = "cookieInfo")
@PropertySource(value = "classpath:/config/cookie.properties")
public class CookieInfo {
    private String loginId;

    private String name;

    private String level;

    public String getLoginId() {
        return loginId;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
