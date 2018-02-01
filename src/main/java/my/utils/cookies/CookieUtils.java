package my.utils.cookies;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
public class CookieUtils {

    protected static String getCookieValue(HttpServletRequest request, String key){
        if (StringUtils.isBlank(key)){
            return null;
        }
        Cookie[] cookies =  request.getCookies();
        if (cookies == null || cookies.length == 0){
            return null;
        }
        for (Cookie cookie :cookies){
            if(key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }
}
