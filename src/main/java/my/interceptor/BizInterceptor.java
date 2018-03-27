package my.interceptor;

import my.common.URLConstants;
import my.component.cookie.CookieInfo;
import my.component.init.InitComponent;
import my.controller.backer.operator.BackerLoginController;
import my.service.cookies.CookieManager;
import my.utils.security.SDCUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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

    @Resource
    private CookieManager cookieManager;

    @Resource
    private CookieInfo cookieInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        cookieManager.setHttpInfo(request, response);
        String url = request.getRequestURI();
        //忽略校验的URl
        for (String loginUrl : URLConstants.getIgnoreUrlList()) {
            if (url.indexOf(loginUrl) != -1) {
                return true;
            }
        }
        String loginId = SDCUtils.decrypt(cookieManager.getCookieValue(cookieInfo.getLoginId()), BackerLoginController.class);
        if (StringUtils.isBlank(loginId)||!InitComponent.OPERATOR_MAP.containsKey(loginId)) {
            response.sendRedirect("/backer/tol");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null){
            modelAndView.addObject("menu",InitComponent.NEST_MENU_LIST);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
