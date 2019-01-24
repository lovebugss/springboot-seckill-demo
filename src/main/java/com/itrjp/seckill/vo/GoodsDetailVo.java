package com.itrjp.seckill.vo;


import com.itrjp.seckill.bean.User;
import lombok.Data;

/**
 * Created by jiangyunxiong on 2018/5/24.
 */
@Data
public class GoodsDetailVo {
    private int seckillStatus = 0;
    private int remainSeconds = 0;
    private GoodsVo goods ;
    private User user;

}
