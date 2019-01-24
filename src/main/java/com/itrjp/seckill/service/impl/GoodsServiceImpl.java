package com.itrjp.seckill.service.impl;/**
 * Created by renjp on 2019/1/24.
 */

import com.itrjp.seckill.bean.Goods;
import com.itrjp.seckill.mapper.GoodsMapper;
import com.itrjp.seckill.service.GoodsService;
import com.itrjp.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/24 14:09
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> query() {
        return this.goodsMapper.selectAll();
    }

    public List<GoodsVo> querySeckillGoodsList() {

        List<GoodsVo> goodsVos = this.goodsMapper.querySeckillGoodsList();
        return goodsVos;
    }
}
