package my.interceptor;

import my.common.URLConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
public class BizInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //忽略校验的URl
       for (String loginUrl : URLConstants.getIgnoreUrlList()){
           if (url.indexOf(loginUrl) != -1){
               return true;
           }
       }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
