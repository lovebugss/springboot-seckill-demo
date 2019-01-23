package com.itrjp.seckill.controller;/**
 * Created by renjp on 2019/1/23.
 */

import com.itrjp.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renjp
 * @Date 2019/1/23 17:06
 * @Version 1.0
 */

@RestController

public class DemoController {

    @GetMapping("demo")
    public Result<String> demo(){

        return Result.success("hahh");
    }
}
