package my.component.cookie;

import my.common.BaseConstants;
import my.exception.NullableException;
import my.utils.cookies.CookieUtils;
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
public class LoginCookies extends CookieUtils {

    private static final int EXPIRY = -1;

    private HttpServletResponse response;

    private HttpServletRequest request;

    /**
     * 写入Cookies
     * @param key
     * @param value
     * @param expiry
     * @throws NullableException
     */
    public void write(String key, String value, int expiry) throws NullableException {
        if (StringUtils.isBlank(key)){
            throw new NullableException();
        }
        Cookie cookie = new Cookie(keyEncrypt(key),value);
        cookie.setMaxAge(expiry);
        this.response.addCookie(cookie);
    }

    /**
     * 写入Cookie(浏览器关闭即清除)
     * @param key
     * @param value
     * @throws NullableException
     */
    public void write(String key, String value) throws NullableException {
        if (StringUtils.isBlank(key)){
            throw new NullableException();
        }
        Cookie cookie = new Cookie(keyEncrypt(key),value);
        cookie.setMaxAge(EXPIRY);
        this.response.addCookie(cookie);
    }

    /**
     * 清除Cookie
     * @param key
     * @throws NullableException
     */
    public void clear(String key)throws NullableException{
        Cookie cookie = new Cookie(key,getCookieValue(this.request,keyEncrypt(key)));
        cookie.setMaxAge(0);
        this.response.addCookie(cookie);
    }

    /**
     * 清除所有Cookies
     * @throws NullableException
     * @throws IllegalAccessException
     */
    public void clear() throws NullableException, IllegalAccessException {
        Field[] fields = CookieInfo.class.getFields();
        for (Field field:fields){
            String key = String.valueOf(field.get(field.getName()));
            if (StringUtils.isNotBlank(key)){
                this.clear(key);
            }
        }
    }

    private static String keyEncrypt(String key) throws NullableException {
        if (StringUtils.isBlank(key)) {
            throw new NullableException(BaseConstants.RespCode.EXCEPTION, "Cookie not avaibable");
        }
        return SDCUtils.encrypt(key);
    }


}
