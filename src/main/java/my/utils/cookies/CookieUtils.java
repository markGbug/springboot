package my.utils.cookies;


import my.common.BaseConstants;
import my.component.cookie.CookieInfo;
import my.exception.NullableException;
import my.utils.security.SDCUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
public class CookieUtils {

    private static final int EXPIRY = -1;

    private HttpServletResponse response;

    private HttpServletRequest request;

    public String getCookieValue(String key) throws NullableException {
        if (key == null || key.length() == 0) {
            return null;
        }
        Cookie[] cookies = this.request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(keyEncrypt(key))) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 写入Cookies
     *
     * @param key
     * @param value
     * @param expiry
     * @throws NullableException
     */
    public void write(String key, String value, int expiry) throws NullableException {
        if (key == null || key.length() == 0) {
            throw new NullableException();
        }
        Cookie cookie = new Cookie(keyEncrypt(key), value);
        cookie.setMaxAge(expiry);
        this.response.addCookie(cookie);
    }

    /**
     * 写入Cookie(浏览器关闭即清除)
     *
     * @param key
     * @param value
     * @throws NullableException
     */
    public void write(String key, String value) throws NullableException {
        if (key == null || key.length() == 0) {
            throw new NullableException();
        }
        Cookie cookie = new Cookie(keyEncrypt(key), value);
        cookie.setMaxAge(EXPIRY);
        this.response.addCookie(cookie);
    }

    /**
     * 清除Cookie
     *
     * @param key
     * @throws NullableException
     */
    public void clear(String key) throws NullableException {
        Cookie cookie = new Cookie(key, getCookieValue(keyEncrypt(key)));
        cookie.setMaxAge(0);
        this.response.addCookie(cookie);
    }

    /**
     * 清除所有Cookies
     *
     * @throws NullableException
     * @throws IllegalAccessException
     */
    public void clear() throws NullableException, IllegalAccessException {
        Field[] fields = CookieInfo.class.getFields();
        for (Field field : fields) {
            String key = String.valueOf(field.get(field.getName()));
            if (StringUtils.isNotBlank(key)) {
                this.clear(key);
            }
        }
    }

    private static String keyEncrypt(String key) throws NullableException {
        if (key == null || key.length() == 0) {
            throw new NullableException(BaseConstants.RespCode.EXCEPTION, "Cookie not avaibable");
        }
        return SDCUtils.encrypt(key);
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setHttpInfo(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

}
