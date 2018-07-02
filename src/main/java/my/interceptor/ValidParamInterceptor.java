package my.interceptor;

import my.common.BaseConstants;
import my.common.BaseJson;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/1
 */
@Aspect
@Order(1)
@Component
public class ValidParamInterceptor {

    @Pointcut(value = "execution(* my.controller..*(..))")
    public void validPointCut() {
    }

    @Around("validPointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] params = joinPoint.getArgs();

        //如果不存在参数，直接进行下一步
        if (ArrayUtils.isEmpty(params)) {
            return joinPoint.proceed();
        }
        //声明参数类型
        BindingResult result = null;
        Model model = null;
        //参数赋值
        for (Object param : params) {
            if (param instanceof BindingResult) {
                result = (BindingResult) param;
            }

            if (param instanceof Model) {
                model = (Model) param;
            }
        }
        //CASE 1 ：不存在BindingResult对象
        //CASE 2 ：BindingResult对象不存在错误
        //RETURN NEXT
        if (null == result || !result.hasErrors()) {
            return joinPoint.proceed();
        }

        //将错误信息装入BaseJson并返回
        List<ObjectError> errors = result.getAllErrors();
        String message = errors.get(0).getDefaultMessage();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        if (isResponseBody(signature.getMethod())) {
            BaseJson baseJson = new BaseJson();
            baseJson.setFailResult(BaseConstants.RespCode.ERROR, message);
            return baseJson;
        }

        if (model != null) {
            model.addAttribute("errMsg", message);
            return "error";
        }
        return null;
    }

    /**
     * 判断是否传回JSON数据
     *
     * @param method
     * @return
     */
    private boolean isResponseBody(Method method) {
        return method.getDeclaredAnnotation(ResponseBody.class) != null;
    }
}
