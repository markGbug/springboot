package my.controller;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/10
 */
public class RedisTest {

    private static RedisTemplate template;

    public static void main(String[] args) {
        template.opsForValue().set();
    }
}
