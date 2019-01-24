package com.itrjp.seckill.service;/**
 * Created by renjp on 2019/1/24.
 */

import com.itrjp.seckill.bean.Goods;
import com.itrjp.seckill.vo.GoodsVo;

import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/24 14:09
 * @Version 1.0
 */
public interface GoodsService {

    List<GoodsVo> querySeckillGoodsList();

    List<Goods> query();
}
