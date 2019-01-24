package com.itrjp.seckill.controller;/**
 * Created by renjp on 2019/1/23.
 */

import com.google.common.util.concurrent.RateLimiter;
import com.itrjp.seckill.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renjp
 * @Date 2019/1/23 17:06
 * @Version 1.0
 */

@RestController

public class DemoController {

    // 使用guava提供的令牌桶算法进行限流
    private RateLimiter limiter = RateLimiter.create(1L);

    @GetMapping("demo")
    public Result<String> demo() {
        // 获取令牌
        if (!limiter.tryAcquire()) {
            //
            return Result.error("error");
        }
        return Result.success("hahh");
    }
}
