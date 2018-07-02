package my.component.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/26
 */
@Aspect
@Order(2)
@Component
public class LogComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogComponent.class);

    @Pointcut(value = "execution(* my.controller.*.*.*(..))")
    public void logPointCut() {
    }


    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer buffer = new StringBuffer("\n");
        buffer.append("url=")
                .append(request.getRequestURL())
                .append("\n")
                .append("remoteIP=")
                .append(request.getRequestURI())
                .append("\n")
                .append("method=")
                .append(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName())
                .append("\n")
                .append("param=")
                .append(joinPoint.getArgs());
        LOGGER.info(buffer.toString());
    }


    @AfterReturning(value = "logPointCut()", returning = "object")
    public void afterReturning(Object object) {
        LOGGER.info("result={}", object.toString());
    }
}
