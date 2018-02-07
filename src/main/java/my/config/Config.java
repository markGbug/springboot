package my.config;

import my.interceptor.BizInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/25
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {


    @Bean
    public BizInterceptor bizInterceptor() {
        return new BizInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bizInterceptor()).addPathPatterns("/**");
    }
}
